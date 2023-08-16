package com.bnta.backend_project_group4.controllers;

import com.bnta.backend_project_group4.models.User;
import com.bnta.backend_project_group4.models.UserDTO;
import com.bnta.backend_project_group4.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    //INDEX
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value= "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> foundUser = userService.getUserById(id);
        if(foundUser.isPresent()){
            return new ResponseEntity<>(foundUser.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<List<User>> createChocolate(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(value="/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable Long id){
        Optional<User> foundUser = userService.getUserById(id);
        if(foundUser.isPresent()){
            userService.deleteUser(id);
            return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
        }
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.NOT_FOUND);
    }
}
