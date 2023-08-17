package com.bnta.backend_project_group4.controllers;

import com.bnta.backend_project_group4.models.Food;
import com.bnta.backend_project_group4.models.Toy;
import com.bnta.backend_project_group4.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    
}
