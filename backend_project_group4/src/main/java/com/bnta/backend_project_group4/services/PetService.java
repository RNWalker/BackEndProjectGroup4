package com.bnta.backend_project_group4.services;

import com.bnta.backend_project_group4.models.Pet;
import com.bnta.backend_project_group4.models.PetDTO;
import com.bnta.backend_project_group4.repositories.PetRepository;
import com.bnta.backend_project_group4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    UserRepository userRepository;

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Long id){
        return petRepository.findById(id);
    }

    public Pet savePet(PetDTO petDTO, Long userId){
        Pet pet = new Pet(petDTO.getName(), petDTO.getSpecies(), petDTO.getHappinessLevel(), petDTO.getEnergyLevel(), userRepository.findById(userId).get());
        petRepository.save(pet);
        return pet;
    }

    public void deletePet(Long id){
        petRepository.deleteById(id);
    }
    
}
