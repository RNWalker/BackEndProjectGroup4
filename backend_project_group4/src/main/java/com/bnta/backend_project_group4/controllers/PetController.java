package com.bnta.backend_project_group4.controllers;

import com.bnta.backend_project_group4.models.Pet;
import com.bnta.backend_project_group4.models.Toy;
import com.bnta.backend_project_group4.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    
}
