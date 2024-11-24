package org.example.models;

public class FitnessProgram {
    private String name;
    private String description;
    private int durationInDays;

    public FitnessProgram() {
        // Default constructor
    }

    public FitnessProgram(String name, String description, int durationInDays) {
        this.name = name;
        this.description = description;
        this.durationInDays = durationInDays;
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

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }
}
