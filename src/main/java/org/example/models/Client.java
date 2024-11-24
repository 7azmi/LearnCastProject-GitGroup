package org.example.models;

public class Client {
    private String name;
    private String email;
    private double bmi;

    public Client() {
        // Default constructor
    }

    public Client(String name, String email, double bmi) {
        this.name = name;
        this.email = email;
        this.bmi = bmi;
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
}
