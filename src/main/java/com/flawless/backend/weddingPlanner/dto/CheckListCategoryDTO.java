package com.flawless.backend.weddingPlanner.dto;

import com.flawless.backend.weddingPlanner.entites.CheckListCategory;

import java.io.Serializable;

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
