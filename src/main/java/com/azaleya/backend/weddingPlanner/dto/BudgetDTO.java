package com.azaleya.backend.weddingPlanner.dto;

import com.azaleya.backend.weddingPlanner.entites.Budget;
import com.azaleya.backend.weddingPlanner.entites.Users;

public class BudgetDTO {
    private String id;
    private Double budget;
    private UsersDTO user;
    public BudgetDTO(){}

    public BudgetDTO(String id, Double budget) {
        this.id = id;
        this.budget = budget;
    }

    public BudgetDTO(Budget entity) {
        id = entity.getId();
        budget = entity.getBudget();
    }
    public BudgetDTO(Budget entity, Users user) {
        this(entity);
        this.user = new UsersDTO(user);
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

    public UsersDTO getUser() {
        return user;
    }

    public void setUser(UsersDTO user) {
        this.user = user;
    }
}
