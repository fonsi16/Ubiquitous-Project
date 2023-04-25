package com.example.project_ubi.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class WorkoutRecord {
    private int id;
    private int userId;
    private int workoutId;
    private LocalDate date;
    private LocalTime time;
    private int duration;
    private float weightUsed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getWeightUsed() {
        return weightUsed;
    }

    public void setWeightUsed(float weightUsed) {
        this.weightUsed = weightUsed;
    }
}
