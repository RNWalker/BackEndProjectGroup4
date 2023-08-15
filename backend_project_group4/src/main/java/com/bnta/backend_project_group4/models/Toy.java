package com.bnta.backend_project_group4.models;

import java.util.ArrayList;

public class Toy {

    private Long id;
    private String name;
    private int happinessValue;
    private ArrayList<Pet> pets;

    public Toy(Long id, String name, int happinessValue) {
        this.id = id;
        this.name = name;
        this.happinessValue = happinessValue;
        this.pets = new ArrayList<>();
    }

    // default constructor

    public Toy(){}

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

    public int getHappinessValue() {
        return happinessValue;
    }

    public void setHappinessValue(int happinessValue) {
        this.happinessValue = happinessValue;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
}
