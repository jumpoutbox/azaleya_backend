package com.azaleya.backend.todoApp.entites;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_budget")
public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double budget;

    @OneToOne(mappedBy = "budget")
    private Users user;

    public Budget(){}

    public Budget(String id, Double budget) {
        this.id = id;
        this.budget = budget;
    }

    public Budget(String id, Double budget, Users user) {
        this.id = id;
        this.budget = budget;
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
