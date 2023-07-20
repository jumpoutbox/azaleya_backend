package com.azaleya.backend.dto;

import com.azaleya.backend.entites.Budget;
import com.azaleya.backend.entites.Users;
import jakarta.persistence.OneToOne;

public class BudgetDTO {
    private String id;
    private Double budget;

    private Users user;

    public BudgetDTO(){}

    public BudgetDTO(String id, Double budget, Users user) {
        this.id = id;
        this.budget = budget;
        this.user = user;
    }

    public BudgetDTO(Budget entity) {
        id = entity.getId();
        budget = entity.getBudget();
        user = entity.getUser();
    }

    public BudgetDTO(Budget budget, Users user) {
        this(budget);
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
