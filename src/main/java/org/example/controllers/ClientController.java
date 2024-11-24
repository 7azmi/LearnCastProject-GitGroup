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
    private static final List<Client> clients = new ArrayList<>();

    // Show the registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("client", new Client()); // Bind an empty Client object to the form
        return "client/register";
    }

    // Show the login form
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("client", new Client()); // Bind an empty Client object to the form
        return "client/login";
    }

    // Process the registration form
    @PostMapping("/register")
    public String processRegisterForm(@ModelAttribute("client") Client client, Model model) {
        // Input validation
        if (client.getName() == null || client.getName().isEmpty()) {
            model.addAttribute("error", "Name is required.");
            return "client/register";
        }
        if (client.getEmail() == null || !client.getEmail().contains("@")) {
            model.addAttribute("error", "Invalid email address.");
            return "client/register";
        }

        // Add the client to the static list
        clients.add(client);

        // Redirect to the profile page
        return "redirect:/client/profile?email=" + client.getEmail();
    }

    // Process the login form
    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("client") Client client, Model model) {
        // Check if client exists
        Client loggedInClient = clients.stream()
                .filter(c -> c.getEmail().equals(client.getEmail()))
                .findFirst()
                .orElse(null);

        if (loggedInClient == null) {
            model.addAttribute("error", "Invalid email or password.");
            return "client/login";
        }

        // Redirect to the profile page
        return "redirect:/client/profile?email=" + loggedInClient.getEmail();
    }

    // Show the client's profile
    @GetMapping("/profile")
    public String showProfile(@RequestParam("email") String email, Model model) {
        // Find the client by email
        Client client = clients.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst()
                .orElse(null);

        if (client == null) {
            model.addAttribute("error", "Client not found.");
            return "client/login";
        }

        // Create a ViewModel and pass data to the view
        ClientViewModel viewModel = new ClientViewModel(client.getName(), client.getEmail(), client.getBmi());
        model.addAttribute("client", viewModel);

        return "client/profile";
    }
}
