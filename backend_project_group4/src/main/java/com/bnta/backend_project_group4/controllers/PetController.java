package com.bnta.backend_project_group4.controllers;

import com.bnta.backend_project_group4.models.Pet;
import com.bnta.backend_project_group4.models.PetDTO;
import com.bnta.backend_project_group4.models.Toy;
import com.bnta.backend_project_group4.models.ToyDTO;
import com.bnta.backend_project_group4.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pets")
public class PetController {

    @Autowired
    PetService petService;

    //INDEX
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets(){
        return new ResponseEntity<>(petService.getAllPets(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value= "/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id){
        Optional<Pet> foundPet = petService.getPetById(id);
        if(foundPet.isPresent()){
            return new ResponseEntity<>(foundPet.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //CREATE
    @PostMapping
    public ResponseEntity<List<Pet>> createPet(@RequestBody PetDTO petDTO){
        petService.savePet(petDTO);
        return new ResponseEntity<>(petService.getAllPets(), HttpStatus.CREATED);
    }

    //DELETE
//    @DeleteMapping(value="/{id}")
//    public ResponseEntity<List<Toy>> deleteToy(@PathVariable Long id){
//        Optional<Toy> foundToy = toyService.getToyById(id);
//        if(foundToy.isPresent()){
//            toyService.deleteToy(id);
//            return new ResponseEntity<>(toyService.getAllToys(),HttpStatus.OK);
//        }
//        return new ResponseEntity<>(toyService.getAllToys(),HttpStatus.NOT_FOUND);
//    }
//
//    // UPDATE
//    @PatchMapping(value ="/{id}")
//    public ResponseEntity<Toy> updateToy(@RequestBody ToyDTO toyDTO, @PathVariable Long id){
//        Toy updatedToy = toyService.updateToy(toyDTO, id);
//        return new ResponseEntity<>(updatedToy, HttpStatus.OK);
//    }


}
