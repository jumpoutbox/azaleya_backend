package com.azaleya.backend.todoApp.dto;

import com.azaleya.backend.todoApp.entites.Budget;

public class BudgetDTO {
    private String id;
    private Double budget;
    public BudgetDTO(){}

    public BudgetDTO(Budget entity) {
        id = entity.getId();
        budget = entity.getBudget();
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
}
