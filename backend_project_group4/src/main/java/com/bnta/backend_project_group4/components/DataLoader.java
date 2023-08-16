package com.bnta.backend_project_group4.components;

import com.bnta.backend_project_group4.models.Pet;
import com.bnta.backend_project_group4.models.Species;
import com.bnta.backend_project_group4.models.Toy;
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
    public DataLoader() {}

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

        Pet pet1 = new Pet("Khaleesi", Species.DRAGON, user1);
        user1.addPet(pet1);
        petRepository.save(pet1);

        Pet pet2 = new Pet("Dougal", Species.DOG, user2);
        user2.addPet(pet2);
        petRepository.save(pet2);

        Pet pet3 = new Pet("Sesame", Species.RAT, user3);
        user3.addPet(pet3);
        petRepository.save(pet3);

        Pet pet4 = new Pet("Tiddles", Species.CAT, user4);
        user4.addPet(pet4);
        petRepository.save(pet4);

        Pet pet5 = new Pet("Drogon", Species.DRAGON, user5);
        user5.addPet(pet5);
        petRepository.save(pet5);

        Pet pet6 = new Pet("Derek", Species.DOG, user5);
        user5.addPet(pet6);
        petRepository.save(pet6);

        Pet pet7 = new Pet("Peach", Species.RAT, user5);
        user5.addPet(pet7);
        petRepository.save(pet7);

        Pet pet8 = new Pet("Giggles", Species.CAT, user5);
        user5.addPet(pet8);
        petRepository.save(pet8);

        //toys

        Toy toy1 = new Toy("Humans", 20);
        toy1.addPet(pet1); //dragon
        toy1.addPet(pet2); //dragon
        toy1.addPet(pet5); //dog
        toy1.addPet(pet6); //dog
        toyRepository.save(toy1);

        Toy toy2 = new Toy("Ball", 20);
        toy2.addPet(pet2); //dog
        toy2.addPet(pet6); //dog
        toyRepository.save(toy2);

        Toy toy3 = new Toy("Stick", 20);
        toy3.addPet(pet2); //dog
        toy3.addPet(pet3); //rat
        toy3.addPet(pet6); //dog
        toy3.addPet(pet7); //rat
        toyRepository.save(toy3);

        Toy toy4 = new Toy("Yarn", 20);
        toy4.addPet(pet4); //cat
        toy4.addPet(pet8); //cat
        toyRepository.save(toy4);

        

    }

}
