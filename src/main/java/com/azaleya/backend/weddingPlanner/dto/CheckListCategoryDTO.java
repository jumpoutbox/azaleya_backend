package com.azaleya.backend.weddingPlanner.dto;

import com.azaleya.backend.weddingPlanner.entites.CheckList;
import com.azaleya.backend.weddingPlanner.entites.CheckListCategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckListCategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;

    public CheckListCategoryDTO(){}

    public CheckListCategoryDTO(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CheckListCategoryDTO(CheckListCategory entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
