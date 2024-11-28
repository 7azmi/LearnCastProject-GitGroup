package org.example.controllers;

import org.example.models.Client;
import org.example.models.ClientViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    // Static list to simulate a database
    private static final List<Client> clientList = new ArrayList<>();

    // Show the registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("client", new Client());
        return "client/register";
    }

    // Show the login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "client/login";
    }

    // Process the registration form
    @PostMapping("/register")
    public String processRegisterForm(
            @ModelAttribute("client") Client client,
            Model model) {

        // Validate inputs
        String errorMessage = validateClient(client);
        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
            return "client/register";
        }

        // Save the validated client to the list
        clientList.add(client);
        model.addAttribute("successMessage", "Registration successful!");
        return "redirect:/client/login";
    }

    // Process the login form
    @PostMapping("/login")
    public String processLoginForm(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {

        // Validate user credentials
        Client client = clientList.stream()
                .filter(c -> c.getEmail().equals(email) && c.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (client == null) {
            model.addAttribute("errorMessage", "Invalid email or password.");
            return "client/login";
        }

        model.addAttribute("client", client);
        return "redirect:/client/profile";
    }

    @GetMapping("/profile")
    public String showProfile(@RequestParam("email") String email, Model model) {
        Client client = clientList.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst()
                .orElse(null);

        if (client != null) {
            ClientViewModel clientViewModel = new ClientViewModel(
                    client.getName(),
                    client.getEmail(),
                    client.getBmi()
            );
            model.addAttribute("client", clientViewModel);
            return "client/profile";
        }

        model.addAttribute("errorMessage", "Client not found.");
        return "client/login";
    }

    @GetMapping("/clients")
    public String showClientList(Model model) {
        List<ClientViewModel> clientViewModels = new ArrayList<>();
        for (Client client : clientList) {
            clientViewModels.add(new ClientViewModel(
                    client.getName(),
                    client.getEmail(),
                    client.getBmi()
            ));
        }
        model.addAttribute("clients", clientViewModels);
        return "admin/clientList";
    }


    // Helper method for validation
    private String validateClient(Client client) {
        if (client.getName() == null || client.getName().isEmpty()) {
            return "Name is required.";
        }
        if (client.getEmail() == null || !client.getEmail().matches(".+@.+\\..+")) {
            return "Valid email is required.";
        }
        if (client.getPassword() == null || client.getPassword().length() < 6) {
            return "Password must be at least 6 characters long.";
        }
        if (client.getBmi() <= 0 || client.getBmi() > 50) {
            return "BMI must be a valid positive number.";
        }
        return null;
    }


}
