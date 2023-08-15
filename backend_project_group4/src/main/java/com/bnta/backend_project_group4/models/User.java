package com.bnta.backend_project_group4.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table(name = "users")
public class User {
    @Column
    private String name;
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"users"})
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

    public void addPet(Pet pet){
        this.pets.add(pet);
    }
}
