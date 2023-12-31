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
        return toyRepository.save(toy);
    }

    public void deleteToy(Long id){
        Toy toyToDelete = toyRepository.findById(id).get();
        for(Pet pet : toyToDelete.getPets()){
            pet.removeToy(toyToDelete);
            petRepository.save(pet);
        }
        toyRepository.deleteById(id);
    }

    public Toy updateToy(ToyDTO toyDTO, Long id){
        Toy toyToUpdate = toyRepository.findById(id).get();

        toyToUpdate.setName(toyDTO.getName());
        toyToUpdate.setHappinessValue(toyDTO.getHappinessValue());

        toyRepository.save(toyToUpdate);
        return toyToUpdate;
    }
}
