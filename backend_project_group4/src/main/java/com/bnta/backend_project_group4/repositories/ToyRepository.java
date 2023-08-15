package com.bnta.backend_project_group4.repositories;

import com.bnta.backend_project_group4.models.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Long> {
}
