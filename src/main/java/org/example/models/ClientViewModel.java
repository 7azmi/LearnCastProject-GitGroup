package org.example.models;

public class ClientViewModel {
    private String name;
    private String email;
    private double bmi;
    private String role; // Optional field for roles, if applicable

    // Constructor
    public ClientViewModel(String name, String email, double bmi, String role) {
        this.name = name;
        this.email = email;
        this.bmi = bmi;
        this.role = role;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
