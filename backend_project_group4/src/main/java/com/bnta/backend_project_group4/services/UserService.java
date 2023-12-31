package com.bnta.backend_project_group4.services;

import com.bnta.backend_project_group4.models.*;
import com.bnta.backend_project_group4.repositories.PetRepository;
import com.bnta.backend_project_group4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

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
        Optional<User> deletedUser = userRepository.findById(id);
        if(deletedUser.isPresent()){
            User user = deletedUser.get();
            userRepository.delete(user);
        }
    }

    public User updateUser(UserDTO userDTO, Long id){
        User userToUpdate= userRepository.findById(id).get();

        userToUpdate.setName(userDTO.getName());
        userToUpdate.setEmail(userDTO.getEmail());

        userRepository.save(userToUpdate);
        return userToUpdate;
    }
}
