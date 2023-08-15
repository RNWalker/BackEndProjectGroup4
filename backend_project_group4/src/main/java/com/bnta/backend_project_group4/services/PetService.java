package com.bnta.backend_project_group4.services;

import com.bnta.backend_project_group4.models.Pet;
import com.bnta.backend_project_group4.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Long id){
        return petRepository.findById(id);
    }

    
}
