package com.bnta.backend_project_group4.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;

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
    @JsonIgnoreProperties({"foods"})
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
