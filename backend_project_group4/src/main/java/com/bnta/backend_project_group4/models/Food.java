package com.bnta.backend_project_group4.models;

import java.util.ArrayList;

public class Food {

    private Long id;
    private String name;
    private int nutritionValue;
    private ArrayList<Pet> pets;

    public Food(Long id, String name, int nutritionValue) {
        this.id = id;
        this.name = name;
        this.nutritionValue = nutritionValue;
        this.pets = new ArrayList<>();
    }

    // default constructor
    public Food(){}

    // getters and setters
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

    public int getNutritionValue() {
        return nutritionValue;
    }

    public void setNutritionValue(int nutritionValue) {
        this.nutritionValue = nutritionValue;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
}
