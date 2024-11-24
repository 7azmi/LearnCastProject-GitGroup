package org.example.models;

public class AdminViewModel {
    private String clientName;
    private String role;

    public AdminViewModel(String clientName, String role) {
        this.clientName = clientName;
        this.role = role;
    }

    // Getters only (to ensure immutability)
    public String getClientName() {
        return clientName;
    }

    public String getRole() {
        return role;
    }
}
