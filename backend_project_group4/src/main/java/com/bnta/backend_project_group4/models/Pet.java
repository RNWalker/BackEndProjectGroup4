package com.bnta.backend_project_group4.models;

import java.util.ArrayList;

public class Pet {

    private Long id;
    private String name;
    private Species species;
    private int happinessLevel;
    private int energyLevel;
    private User user;
    private ArrayList<Toy> toys;
    private ArrayList<Food> foods;

    public Pet(Long id, String name, Species species, int happinessLevel, int energyLevel, User user) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.happinessLevel = happinessLevel;
        this.energyLevel = energyLevel;
        this.user = user;
        this.toys = new ArrayList<>();
        this.foods = new ArrayList<>();
    }

    // default constructor
    public Pet(){}

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }

    public void setHappinessLevel(int happinessLevel) {
        this.happinessLevel = happinessLevel;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public void setToys(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
}
