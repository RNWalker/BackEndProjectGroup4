package com.bnta.backend_project_group4.models;

import java.util.List;

public class PetDTO {

    private String name;
    private Species species;
    private int happinessLevel;
    private int energyLevel;
    private Long userId;
    private List<Long> toyIds;
    private List<Long> foodIds;

    public PetDTO(String name, Species species,  Long userId, List<Long> toyIds, List<Long> foodIds) {
        this.name = name;
        this.species = species;
        this.happinessLevel = 50;
        this.energyLevel = 50;
        this.userId = userId;
        this.toyIds = toyIds;
        this.foodIds = foodIds;
    }

    // default constructor
    public PetDTO() {}

    //getters and setters

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getToyIds() {
        return toyIds;
    }

    public void setToyIds(List<Long> toyIds) {
        this.toyIds = toyIds;
    }

    public List<Long> getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(List<Long> foodIds) {
        this.foodIds = foodIds;
    }
}
