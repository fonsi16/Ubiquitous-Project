package com.example.project_ubi.model;

public class Exercise {
    private int id;
    private String name;
    private String workedMuscles;
    private String description;
    private byte[] image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkedMuscles() {
        return workedMuscles;
    }

    public void setWorkedMuscles(String workedMuscles) {
        this.workedMuscles = workedMuscles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
