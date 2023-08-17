package com.bnta.backend_project_group4.services;

import com.bnta.backend_project_group4.models.*;
import com.bnta.backend_project_group4.repositories.FoodRepository;
import com.bnta.backend_project_group4.repositories.PetRepository;
import com.bnta.backend_project_group4.repositories.ToyRepository;
import com.bnta.backend_project_group4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Autowired
    FoodRepository foodRepository;

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Long id){
        return petRepository.findById(id);
    }

    // check later re passing in toys/food
    public Pet savePet(PetDTO petDTO){
        Pet pet = new Pet(petDTO.getName(), petDTO.getSpecies(), userRepository.findById(petDTO.getUserId()).get());
        petRepository.save(pet);
        return pet;
    }

    public void deletePet(Long id){
        petRepository.deleteById(id);
    }

    public Pet updatePet(PetDTO petDTO, Long petId){
        Pet petToUpdate = petRepository.findById(petId).get();

        petToUpdate.setName(petDTO.getName());
        petToUpdate.setSpecies(petDTO.getSpecies());
        petToUpdate.setHappinessLevel(petDTO.getHappinessLevel());
        petToUpdate.setEnergyLevel(petDTO.getEnergyLevel());
        petToUpdate.setId(petDTO.getUserId());
        petToUpdate.setFoods(new ArrayList<>());

        for (Long id: petDTO.getFoodIds()){
            Food food = foodRepository.findById(id).get();
            petToUpdate.addFood(food);
            foodRepository.save(food);
        }

        petToUpdate.setToys(new ArrayList<>());

        for (Long id: petDTO.getToyIds()){
            Toy toy = toyRepository.findById(id).get();
            petToUpdate.addToy(toy);
            toyRepository.save(toy);
        }

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
            Toy toy = toyRepository.findById(toyId).get();

            petBeingPlayedWith.setHappinessLevel(petBeingPlayedWith.getHappinessLevel() + toy.getHappinessValue());
            petBeingPlayedWith.removeToy(toy);
            petRepository.save(petBeingPlayedWith);
//        } //else throws exception
    }

    public void feedPet(Long foodId, Long petId){
        Pet petBeingFed = petRepository.findById(petId).get();
        Food food= foodRepository.findById(foodId).get();

        petBeingFed.setEnergyLevel(petBeingFed.getEnergyLevel()+food.getNutritionValue());
        petBeingFed.removeFood(food);
        petRepository.save(petBeingFed);
    }

    @Scheduled(fixedRate = 1000) //note: 15000 = 15 seconds
    public void autoDecrease() {
        for (Pet petDecreasing : petRepository.findAll()) {
            petDecreasing.setEnergyLevel(petDecreasing.getEnergyLevel() - 2);
            petDecreasing.setHappinessLevel(petDecreasing.getHappinessLevel() - 2);
            if(petDecreasing.getHappinessLevel() <= 0 || petDecreasing.getEnergyLevel() <= 0){
                petRepository.deleteById(petDecreasing.getId());
                continue;
            }
            petRepository.save(petDecreasing);
        }
    }

    public List<Pet> findAllPetsWithHappinessLevelLessThanOrEnergyLevelLessThan(int happinessLevel, int energyLevel){
        return petRepository.findByHappinessLevelLessThanOrEnergyLevelLessThan(happinessLevel, energyLevel);
    }
//    public List<Pet> findAllPetsWithEnergyLevelLessThan(int energyLevel){
//        return petRepository.findByEnergyLevelLessThan(energyLevel);
//    }
}
