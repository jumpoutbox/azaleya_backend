package com.azaleya.backend.todoApp.repository;

import com.azaleya.backend.todoApp.entites.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, String> {
}
