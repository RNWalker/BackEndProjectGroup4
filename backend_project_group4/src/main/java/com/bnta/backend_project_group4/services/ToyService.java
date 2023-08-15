package com.bnta.backend_project_group4.services;

import com.bnta.backend_project_group4.models.Pet;
import com.bnta.backend_project_group4.models.Toy;
import com.bnta.backend_project_group4.models.ToyDTO;
import com.bnta.backend_project_group4.models.User;
import com.bnta.backend_project_group4.repositories.PetRepository;
import com.bnta.backend_project_group4.repositories.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    // May need to amend later to also delete pet
    public void deleteToy(Long id){
        toyRepository.deleteById(id);
    }
    public Toy updateToy(ToyDTO toyDTO, Long id){
        Toy toyToUpdate = toyRepository.findById(id).get();
        toyToUpdate.setName(toyDTO.getName());
        toyToUpdate.setHappinessValue(toyDTO.getHappinessValue());
        toyToUpdate.setPets(new ArrayList<Pet>());
        for (Long petId: toyDTO.getPetIds()){
            Pet pet = petRepository.findById(petId).get();
            toyToUpdate.addPet(pet);
        }
        toyRepository.save(toyToUpdate);
        return toyToUpdate;

    }

}
