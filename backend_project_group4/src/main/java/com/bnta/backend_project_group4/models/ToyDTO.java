package com.bnta.backend_project_group4.models;

import java.util.List;

public class ToyDTO {

    private String name;
    private int happinessValue;
    private List<Long> petIds;

    public ToyDTO(String name, int happinessValue) {
        this.name = name;
        this.happinessValue = happinessValue;
    }

    // default constructor
    public ToyDTO() {}

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHappinessValue() {
        return happinessValue;
    }

    public void setHappinessValue(int happinessValue) {
        this.happinessValue = happinessValue;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }
}
