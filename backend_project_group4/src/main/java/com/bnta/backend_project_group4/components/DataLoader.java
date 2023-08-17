package com.bnta.backend_project_group4.components;

import com.bnta.backend_project_group4.models.*;
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
        pet1.addToy(toy1);
        pet2.addToy(toy1);
        pet5.addToy(toy1);
        pet6.addToy(toy1);
        toyRepository.save(toy1);

        Toy toy2 = new Toy("Ball", 20);
        pet2.addToy(toy2);
        pet6.addToy(toy2);
        toyRepository.save(toy2);

        Toy toy3 = new Toy("Stick", 20);
        pet2.addToy(toy3);
        pet3.addToy(toy3);
        pet6.addToy(toy3);
        pet7.addToy(toy3);
        toyRepository.save(toy3);

        Toy toy4 = new Toy("Yarn", 20);
        pet4.addToy(toy4);
        pet8.addToy(toy4);
        toyRepository.save(toy4);

        // food

        Food food1 = new Food("Raw meat", 20);
        pet1.addFood(food1);
        pet5.addFood(food1);
        pet2.addFood(food1);
        pet6.addFood(food1);
        pet4.addFood(food1);
        pet8.addFood(food1);
        foodRepository.save(food1);

        Food food2 = new Food("Kibble", 20);
        pet2.addFood(food2);
        pet6.addFood(food2);
        pet3.addFood(food2);
        pet7.addFood(food2);
        pet4.addFood(food2);
        pet8.addFood(food2);
        foodRepository.save(food2);

        Food food3 = new Food("Kipper", 20);
        pet4.addFood(food3);
        pet8.addFood(food3);
        pet2.addFood(food3);
        pet6.addFood(food3);
        pet3.addFood(food3);
        pet7.addFood(food3);
        foodRepository.save(food3);

        Food food4 = new Food("Human Leg", 20);
        pet1.addFood(food4);
        pet5.addFood(food4);
        foodRepository.save(food4);

        petRepository.save(pet1);
        petRepository.save(pet2);
        petRepository.save(pet3);
        petRepository.save(pet4);
        petRepository.save(pet5);
        petRepository.save(pet6);
        petRepository.save(pet7);
        petRepository.save(pet8);
    }
}
