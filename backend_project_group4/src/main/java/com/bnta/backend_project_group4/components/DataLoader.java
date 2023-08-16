package com.bnta.backend_project_group4.components;

import com.bnta.backend_project_group4.models.Pet;
import com.bnta.backend_project_group4.models.Species;
import com.bnta.backend_project_group4.models.User;
import com.bnta.backend_project_group4.repositories.FoodRepository;
import com.bnta.backend_project_group4.repositories.PetRepository;
import com.bnta.backend_project_group4.repositories.ToyRepository;
import com.bnta.backend_project_group4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PetRepository petRepository;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    ToyRepository toyRepository;

    @Autowired
    UserRepository userRepository;

    // DEFAULT CONSTRUCTOR
    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
        // users
        User user1 = new User("MotherOfDragons","james@MotherOfDragons");
        userRepository.save(user1);

        User user2 = new User("MotherOfDogs","sarah@MotherOfDogs");
        userRepository.save(user2);

        User user3 =  new User("MotherOfRats","rebecca@MotherOfRats");
        userRepository.save(user3);

        User user4 = new User("MotherOfCats", "charlotte@MotherOfCats");
        userRepository.save(user4);

        User user5 = new User("MotherOfAll","zaiyad@MotherOfAll");
        userRepository.save(user5);

        // pets

        Pet pet1 = new Pet("Khaleesi", Species.DRAGON,50,15,)
    }

}
