package com.bnta.backend_project_group4.services;

import com.bnta.backend_project_group4.models.*;
import com.bnta.backend_project_group4.repositories.PetRepository;
import com.bnta.backend_project_group4.repositories.ToyRepository;
import com.bnta.backend_project_group4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ToyRepository toyRepository;

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Long id){
        return petRepository.findById(id);
    }

    // check later re passing in toys/food
    public Pet savePet(PetDTO petDTO, Long userId){
        Pet pet = new Pet(petDTO.getName(), petDTO.getSpecies(), petDTO.getHappinessLevel(), petDTO.getEnergyLevel(), userRepository.findById(userId).get());
        petRepository.save(pet);
        return pet;
    }

    public void deletePet(Long id){
        petRepository.deleteById(id);
    }

    public Pet updatePet(PetDTO petDTO, Long id){
        Pet petToUpdate = petRepository.findById(id).get();

        petToUpdate.setName(petDTO.getName());
        petToUpdate.setSpecies(petDTO.getSpecies());
        petToUpdate.setHappinessLevel(petDTO.getHappinessLevel());
        petToUpdate.setEnergyLevel(petDTO.getEnergyLevel());
        petToUpdate.setToys(new ArrayList<Toy>());
        petToUpdate.setFoods(new ArrayList<Food>());

        petRepository.save(petToUpdate);
        return petToUpdate;
    }

    public void playWithPet(Long toyId, Long petId){
        //created petBeingPlayedWith and findPetById
        //if statement checking if toy is present in list of toys
        //happinessLevel of the pet will increase by the happinessValue of the toy
        //save pet
        // delete toy

        Pet petBeingPlayedWith = petRepository.findById(petId).get();
        if (petBeingPlayedWith.getToys().contains(toyRepository.findById(toyId))){
            Toy toy = toyRepository.findById(toyId).get();
            petBeingPlayedWith.setHappinessLevel(petBeingPlayedWith.getHappinessLevel() + toy.getHappinessValue());
            petRepository.save(petBeingPlayedWith);
            petBeingPlayedWith.getToys().remove(toyRepository.findById(toyId));
        }
    }
}
