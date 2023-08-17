package com.bnta.backend_project_group4.repositories;

import com.bnta.backend_project_group4.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {

    List<Pet> findByHappinessLevelLessThanOrEnergyLevelLessThan(int happinessLevel, int energyLevel);
//    List<Pet> findByEnergyLevelLessThan(int energyLevel);
}
