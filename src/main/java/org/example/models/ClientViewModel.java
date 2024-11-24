package org.example.models;

public class ClientViewModel {
    private String name;
    private String email;
    private double bmi;

    public ClientViewModel(String name, String email, double bmi) {
        this.name = name;
        this.email = email;
        this.bmi = bmi;
    }

    // Getters only (no setters to make it immutable)
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBmi() {
        return bmi;
    }
}
