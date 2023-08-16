package com.bnta.backend_project_group4.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "toys")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private int happinessValue;

    @Column
    @ManyToMany(mappedBy = "toys")
    @JsonIgnoreProperties({"toys"})
    private List<Pet> pets;

    public Toy(String name, int happinessValue) {
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet){
        this.pets.add(pet);
    }
}
