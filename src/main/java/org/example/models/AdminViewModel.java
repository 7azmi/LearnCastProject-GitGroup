package org.example.models;

public class AdminViewModel {

    private String name;
    private String description;
    private int duration;
    private String clientName;
    private String clientEmail;
    private String role;

    // Constructor for Fitness Program
    public AdminViewModel(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    // Constructor for Client Role Management
    public AdminViewModel(String clientName, String clientEmail, String role) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.role = role;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
