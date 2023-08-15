package com.bnta.backend_project_group4.services;

import com.bnta.backend_project_group4.models.Pet;
import com.bnta.backend_project_group4.models.Toy;
import com.bnta.backend_project_group4.models.ToyDTO;
import com.bnta.backend_project_group4.repositories.PetRepository;
import com.bnta.backend_project_group4.repositories.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToyService {

    @Autowired
    ToyRepository toyRepository;

    @Autowired
    PetRepository petRepository;

    public List<Toy> getAllToys(){
        return toyRepository.findAll();
    }

    public Optional<Toy> getToyById(Long id){
        return toyRepository.findById(id);
    }

    public Toy saveToy(ToyDTO toyDTO){
        Toy toy = new Toy(toyDTO.getName(),toyDTO.getHappinessValue());
        for (Long petId : toyDTO.getPetIds() ) {
            Pet pet = petRepository.findById(petId).get();
            toy.addPet(pet);
        }
        return toyRepository.save(toy);
    }

}
