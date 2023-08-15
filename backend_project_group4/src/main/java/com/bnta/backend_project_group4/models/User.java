package com.bnta.backend_project_group4.models;

import java.util.ArrayList;

public class User {

    private String name;
    private Long id;
    private String email;
    private ArrayList<Pet> pets;

    public User(String name, Long id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.pets = new ArrayList<>();
    }

    // default constructor
    public User(){}

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
}
