package com.bnta.backend_project_group4.controllers;

import com.bnta.backend_project_group4.models.Food;
import com.bnta.backend_project_group4.models.FoodDTO;
import com.bnta.backend_project_group4.models.Toy;
import com.bnta.backend_project_group4.models.ToyDTO;
import com.bnta.backend_project_group4.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("foods")
public class FoodController {

    @Autowired
    FoodService foodService;

    //INDEX
    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods(){
        return new ResponseEntity<>(foodService.getAllFoods(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value= "/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id){
        Optional<Food> foundFood = foodService.getFoodById(id);
        if(foundFood.isPresent()){
            return new ResponseEntity<>(foundFood.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<List<Food>> createFood(@RequestBody FoodDTO foodDTO){
        foodService.saveFood(foodDTO);
        return new ResponseEntity<>(foodService.getAllFoods(), HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(value="/{id}")
    public ResponseEntity<List<Food>> deleteFood(@PathVariable Long id){
        Optional<Food> foundFood = foodService.getFoodById(id);
        if(foundFood.isPresent()){
            foodService.deleteFood(id);
            return new ResponseEntity<>(foodService.getAllFoods(),HttpStatus.OK);
        }
        return new ResponseEntity<>(foodService.getAllFoods(),HttpStatus.NOT_FOUND);
    }

    // UPDATE
    @PatchMapping(value ="/{id}")
    public ResponseEntity<Food> updateFood(@RequestBody FoodDTO foodDTO, @PathVariable Long id){
        Food updatedFood = foodService.updateFood(foodDTO, id);
        return new ResponseEntity<>(updatedFood, HttpStatus.OK);
    }



}
