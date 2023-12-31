package com.bnta.backend_project_group4.controllers;

import com.bnta.backend_project_group4.models.Toy;
import com.bnta.backend_project_group4.models.ToyDTO;
import com.bnta.backend_project_group4.models.User;
import com.bnta.backend_project_group4.models.UserDTO;
import com.bnta.backend_project_group4.services.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("toys")
public class ToyController {

    @Autowired
    ToyService toyService;

    //INDEX
    @GetMapping
    public ResponseEntity<List<Toy>> getAllToys(){
        return new ResponseEntity<>(toyService.getAllToys(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value= "/{id}")
    public ResponseEntity<Toy> getToyById(@PathVariable Long id){
        Optional<Toy> foundToy = toyService.getToyById(id);

        if(foundToy.isPresent()){
            return new ResponseEntity<>(foundToy.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //CREATE
    @PostMapping
    public ResponseEntity<List<Toy>> createToy(@RequestBody ToyDTO toyDTO){
        toyService.saveToy(toyDTO);
        return new ResponseEntity<>(toyService.getAllToys(), HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(value="/{id}")
    public ResponseEntity<List<Toy>> deleteToy(@PathVariable Long id){
        Optional<Toy> foundToy = toyService.getToyById(id);

        if(foundToy.isPresent()){
            toyService.deleteToy(id);
            return new ResponseEntity<>(toyService.getAllToys(),HttpStatus.OK);
        }
        return new ResponseEntity<>(toyService.getAllToys(),HttpStatus.NOT_FOUND);
    }

    // UPDATE
    @PatchMapping(value ="/{id}")
    public ResponseEntity<Toy> updateToy(@RequestBody ToyDTO toyDTO, @PathVariable Long id){
        Toy updatedToy = toyService.updateToy(toyDTO, id);
        return new ResponseEntity<>(updatedToy, HttpStatus.OK);
    }




}
