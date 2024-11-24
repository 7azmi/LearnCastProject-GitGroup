package org.example.controllers;

import org.example.models.Client;
import org.example.models.FitnessProgram;
import org.example.models.AdminViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // Static lists to simulate databases
    private static final List<Client> clients = new ArrayList<>();
    private static final List<FitnessProgram> programs = new ArrayList<>();

    // Show the list of clients
    @GetMapping("/clientList")
    public String showClientList(Model model) {
        model.addAttribute("clients", clients);
        return "admin/clientList";
    }

    // Show the form to add a fitness program
    @GetMapping("/addProgram")
    public String showAddProgramForm(Model model) {
        model.addAttribute("fitnessProgram", new FitnessProgram());
        return "admin/addProgram";
    }

    // Process the form to add a new fitness program
    @PostMapping("/addProgram")
    public String processAddProgramForm(@ModelAttribute("fitnessProgram") FitnessProgram fitnessProgram, Model model) {
        // Validate input
        if (fitnessProgram.getName() == null || fitnessProgram.getName().isEmpty()) {
            model.addAttribute("error", "Program name is required.");
            return "admin/addProgram";
        }

        // Add the program to the list
        programs.add(fitnessProgram);

        // Redirect to the list of programs
        return "redirect:/admin/clientList";
    }

    // Show the manage roles page
    @GetMapping("/manageRoles")
    public String showManageRoles(Model model) {
        // Pass clients and roles to the view
        model.addAttribute("clients", clients);
        model.addAttribute("roles", List.of("User", "Admin", "Trainer"));
        return "admin/manageRoles";
    }
}
