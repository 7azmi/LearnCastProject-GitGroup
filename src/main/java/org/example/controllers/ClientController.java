package org.example.controllers;

import org.example.models.Client;
import org.example.models.ClientViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientController {

    private static final List<Client> clients = new ArrayList<>();

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("client", new Client());
        return "client/register";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "client/login";
    }

    @PostMapping("/register")
    public String processRegisterForm(@ModelAttribute("client") Client client, Model model) {
        // Input validation (basic example)
        if (client.getName() == null || client.getName().isEmpty()) {
            model.addAttribute("error", "Name is required.");
            return "client/register";
        }
        if (client.getEmail() == null || !client.getEmail().contains("@")) {
            model.addAttribute("error", "Invalid email address.");
            return "client/register";
        }

        // Store the client in the static list
        clients.add(client);
        model.addAttribute("success", "Registration successful! Please log in.");
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String processLoginForm(@RequestParam("email") String email,
                                   @RequestParam("password") String password, Model model) {
        for (Client client : clients) {
            if (client.getEmail().equals(email) && client.getPassword().equals(password)) {
                model.addAttribute("client", client);
                return "redirect:/profile";
            }
        }
        model.addAttribute("error", "Invalid credentials. Please try again.");
        return "client/login";
    }

    @GetMapping("/profile")
    public String showProfile(@RequestParam("email") String email, Model model) {
        for (Client client : clients) {
            if (client.getEmail().equals(email)) {
                ClientViewModel clientViewModel = new ClientViewModel(
                        client.getName(),
                        client.getEmail(),
                        client.getBmi(),
                        "User" // Assuming a default role
                );
                model.addAttribute("client", clientViewModel);
                return "client/profile";
            }
        }
        model.addAttribute("error", "Client not found.");
        return "client/login";
    }



}
