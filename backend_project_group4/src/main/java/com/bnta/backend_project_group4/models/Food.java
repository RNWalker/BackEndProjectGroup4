package com.bnta.backend_project_group4.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foods")
public class Food {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int nutritionValue;

    @Column
    @ManyToMany(mappedBy = "foods")
    @JsonIgnoreProperties({"foods", "toys", "user"})
    private List<Pet> pets;

    public Food(String name, int nutritionValue) {
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet){ this.pets.add(pet); }
}
