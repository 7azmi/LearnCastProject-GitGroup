package org.example.controllers;

import org.example.models.AdminViewModel;
import org.example.models.Client;
import org.example.models.FitnessProgram;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // Static lists to simulate a database
    private static final List<Client> clientList = new ArrayList<>();
    private static final List<FitnessProgram> programList = new ArrayList<>();

    // Display the list of all clients
    @GetMapping("/clients")
    public String showClientList(Model model) {
        model.addAttribute("clients", clientList);
        return "admin/clientList";
    }

    // Show the form to add a new fitness program
    @GetMapping("/addProgram")
    public String showAddProgramForm(Model model) {
        AdminViewModel programViewModel = new AdminViewModel("", "", 0);
        model.addAttribute("program", programViewModel);
        return "admin/addProgram";
    }

    @GetMapping("/manageRoles")
    public String showManageRoles(Model model) {
        List<AdminViewModel> roleViewModels = new ArrayList<>();
        for (Client client : clientList) {
            roleViewModels.add(new AdminViewModel(
                    client.getName(),
                    client.getEmail(),
                    client.getRole()
            ));
        }
        model.addAttribute("clients", roleViewModels);
        return "admin/manageRoles";
    }

    // Process the form submission for a new fitness program
    @PostMapping("/addProgram")
    public String processAddProgramForm(
            @ModelAttribute("fitnessProgram") FitnessProgram fitnessProgram,
            Model model) {

        // Validate inputs
        String errorMessage = validateProgram(fitnessProgram);
        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
            return "admin/addProgram";
        }

        // Save the validated program to the list
        programList.add(fitnessProgram);
        model.addAttribute("successMessage", "Program added successfully!");
        return "redirect:/admin/clients";
    }

    // Show the manage roles page
//    @GetMapping("/manageRoles")
//    public String showManageRoles(Model model) {
//        model.addAttribute("clients", clientList);
//        return "admin/manageRoles";
//    }

    // Helper method to validate fitness program input
    private String validateProgram(FitnessProgram program) {
        if (program.getName() == null || program.getName().isEmpty()) {
            return "Program name is required.";
        }
        if (program.getDescription() == null || program.getDescription().isEmpty()) {
            return "Program description is required.";
        }
        if (program.getDuration() <= 0) {
            return "Program duration must be a positive number.";
        }
        return null;
    }
}
