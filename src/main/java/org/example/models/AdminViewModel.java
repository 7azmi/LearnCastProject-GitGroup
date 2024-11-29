package org.example.models;

import java.util.List;

public class AdminViewModel {
    private List<ClientViewModel> clients; // For manageRoles.jsp
    private List<FitnessProgram> programs; // For program management views

    // Constructor
    public AdminViewModel(List<ClientViewModel> clients, List<FitnessProgram> programs) {
        this.clients = clients;
        this.programs = programs;
    }

    // Getters and Setters
    public List<ClientViewModel> getClients() {
        return clients;
    }

    public void setClients(List<ClientViewModel> clients) {
        this.clients = clients;
    }

    public List<FitnessProgram> getPrograms() {
        return programs;
    }

    public void setPrograms(List<FitnessProgram> programs) {
        this.programs = programs;
    }
}
