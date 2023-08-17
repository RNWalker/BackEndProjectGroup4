package com.bnta.backend_project_group4.controllers;

import com.bnta.backend_project_group4.models.*;
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
    public ResponseEntity<List<Pet>> getAllPets(@RequestParam( required=false, name = "Level") Integer level ){
        if(level!=null){
            return new ResponseEntity<>(petService.findAllPetsWithHappinessLevelLessThan(level),HttpStatus.OK);
        }
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
    @DeleteMapping(value="/{id}")
    public ResponseEntity<List<Pet>> deletePet(@PathVariable Long id){
        Optional<Pet> foundPet = petService.getPetById(id);
        if(foundPet.isPresent()){
            petService.deletePet(id);
            return new ResponseEntity<>(petService.getAllPets(),HttpStatus.OK);
        }
        return new ResponseEntity<>(petService.getAllPets(),HttpStatus.NOT_FOUND);
    }

    // UPDATE
    @PatchMapping(value ="/{id}")
    public ResponseEntity<Pet> updatePet(@RequestBody PetDTO petDTO, @PathVariable Long id){
        Pet updatedPet = petService.updatePet(petDTO, id);
        return new ResponseEntity<>(updatedPet, HttpStatus.OK);
    }

    // localhost:8080/pets/1/feed?foodId=1
    @PatchMapping(value = "/{id}/feed")
    public ResponseEntity<Pet> feedPet(@RequestParam Long foodId, @PathVariable Long id){
        petService.feedPet(foodId, id);
        return new ResponseEntity(getPetById(id), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}/play")
    public ResponseEntity<Pet> playWithPet(@RequestParam Long toyId, @PathVariable Long id){
        petService.playWithPet(toyId, id);
        return new ResponseEntity(getPetById(id), HttpStatus.OK);
    }
}
