package org.example.controllers;

import org.example.models.AdminViewModel;
import org.example.models.Client;
import org.example.models.ClientViewModel;
import org.example.models.FitnessProgram;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private static final List<Client> clients = new ArrayList<>(); // Assuming shared with ClientController
    private static final List<FitnessProgram> programs = new ArrayList<>();

    @GetMapping("/admin/clients")
    public String showClientList(Model model) {
        List<ClientViewModel> clientViewModels = new ArrayList<>();
        for (Client client : clients) {
            clientViewModels.add(new ClientViewModel(
                    client.getName(),
                    client.getEmail(),
                    client.getBmi(),
                    "User" // Replace with actual role if available
            ));
        }
        model.addAttribute("clients", clientViewModels);
        return "admin/clientList";
    }

    @GetMapping("/admin/addProgram")
    public String showAddProgramForm(Model model) {
        model.addAttribute("program", new FitnessProgram());
        return "admin/addProgram";
    }


    @PostMapping("/admin/addProgram")
    public String processAddProgramForm(@ModelAttribute("program") FitnessProgram program, Model model) {
        // Input validation
        if (program.getName() == null || program.getName().isEmpty()) {
            model.addAttribute("error", "Program name is required.");
            return "admin/addProgram";
        }
        if (program.getDuration() <= 0) {
            model.addAttribute("error", "Duration must be greater than 0.");
            return "admin/addProgram";
        }

        // Add program to the static list
        programs.add(program);
        model.addAttribute("success", "Program added successfully.");
        return "redirect:/admin/clients";
    }

    @GetMapping("/admin/manageRoles")
    public String showManageRoles(Model model) {
        List<ClientViewModel> clientViewModels = new ArrayList<>();
        for (Client client : clients) {
            clientViewModels.add(new ClientViewModel(
                    client.getName(),
                    client.getEmail(),
                    client.getBmi(),
                    "User" // Replace with actual role if available
            ));
        }
        AdminViewModel adminViewModel = new AdminViewModel(clientViewModels, programs);
        model.addAttribute("adminViewModel", adminViewModel);
        return "admin/manageRoles";
    }

}
