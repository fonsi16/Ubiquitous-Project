package com.example.project_ubi.model;

public class Workout {
    private int id;
    private int workoutPlanId;
    private int exerciseId;
    private int repetitions;
    private int sets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkoutPlanId() {
        return workoutPlanId;
    }

    public void setWorkoutPlanId(int workoutPlanId) {
        this.workoutPlanId = workoutPlanId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }
}
