package com.bnta.backend_project_group4.repositories;

import com.bnta.backend_project_group4.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
