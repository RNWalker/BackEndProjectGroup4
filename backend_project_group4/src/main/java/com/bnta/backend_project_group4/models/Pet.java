package com.bnta.backend_project_group4.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {
    @Column
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Species species;

    @Column
    private int happinessLevel;

    @Column
    private int energyLevel;

    @ManyToOne
    @JoinColumn (name = "user_id")
    @JsonIgnoreProperties({"pets"})
    private User user;

    @ManyToMany
    @JsonIgnoreProperties({"pets"})
    @JoinTable(
            name = "pets_toys",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "toy_id")
    )
    private List<Toy> toys;

    @ManyToMany
    @JsonIgnoreProperties({"pets"})
    @JoinTable(
            name = "pets_foods",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<Food> foods;

    public Pet(String name, Species species, User user) {
        this.name = name;
        this.species = species;
        this.happinessLevel = 50;
        this.energyLevel = 50;
        this.user = user;
        this.toys = new ArrayList<>();
        this.foods = new ArrayList<>();
    }

    // default constructor
    public Pet(){}

    //getters and setters
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }

    public void addToy(Toy toy) {
        this.toys.add(toy);
    }

    public void removeToy(Toy toy){
        this.toys.remove(toy);
    }

    public void removeFood(Food food){
        this.foods.remove(food);
    }

}
