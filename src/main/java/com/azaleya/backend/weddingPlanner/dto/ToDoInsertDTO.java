package com.azaleya.backend.weddingPlanner.dto;

import com.azaleya.backend.weddingPlanner.entites.CheckListCategory;

import java.util.List;

public class ToDoInsertDTO extends CheckListDTO{

    private List<CheckListCategory> categoria;

    public ToDoInsertDTO(){
        super();
    }
    public List<CheckListCategory> getCategoria() {
        return categoria;
    }
    public void setCategoria(List<CheckListCategory> categoria) {
        this.categoria = categoria;
    }
}
