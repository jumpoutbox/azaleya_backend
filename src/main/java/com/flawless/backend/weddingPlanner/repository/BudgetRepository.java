package com.flawless.backend.weddingPlanner.repository;

import com.flawless.backend.weddingPlanner.entites.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, String> {
}
