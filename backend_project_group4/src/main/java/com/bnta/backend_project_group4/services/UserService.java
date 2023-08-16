package com.bnta.backend_project_group4.services;

import com.bnta.backend_project_group4.models.*;
import com.bnta.backend_project_group4.repositories.PetRepository;
import com.bnta.backend_project_group4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PetRepository petRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User saveUser(UserDTO userDTO){
        User user = new User(userDTO.getName(),userDTO.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        // ? delete food from pet, toy from pet. then pet from user
        User deletedUser= userRepository.getById(id);
        List<Pet> petsToBeDeleted= deletedUser.getPets();
        for(Pet pet :petsToBeDeleted){
            for(Toy toy: pet.getToys()) {
                pet.removeToy(toy);
            }
            for(Food food:pet.getFoods()){
                pet.removeFood(food);
            }
            deletedUser.removePet(pet);
            petRepository.deleteById(pet.getId());
        }
        userRepository.deleteById(id);
    }

    public User updateUser(UserDTO userDTO, Long id){
        User userToUpdate= userRepository.findById(id).get();

        userToUpdate.setName(userDTO.getName());
        userToUpdate.setEmail(userDTO.getEmail());
        userToUpdate.setPets(new ArrayList<Pet>());

        for(Long petId: userDTO.getPetIds()){
            Pet pet= petRepository.findById(petId).get();
            userToUpdate.addPet(pet);
        }
        userRepository.save(userToUpdate);
        return userToUpdate;
    }
}
