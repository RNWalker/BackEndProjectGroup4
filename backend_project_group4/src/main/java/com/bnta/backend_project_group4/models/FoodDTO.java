package com.bnta.backend_project_group4.models;

import java.util.List;

public class FoodDTO {

    private String name;
    private int nutritionValue;
    private List<Long> petIds;

    public FoodDTO(String name, int nutritionValue, List<Long> petIds) {
        this.name = name;
        this.nutritionValue = nutritionValue;
        this.petIds = petIds;
    }

    //default constructor

    public FoodDTO() {}

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNutritionValue() {
        return nutritionValue;
    }

    public void setNutritionValue(int nutritionValue) {
        this.nutritionValue = nutritionValue;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }
}
