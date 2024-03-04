package com.flawless.backend.weddingPlanner.dto;


import com.flawless.backend.weddingPlanner.entites.CheckList;
import com.flawless.backend.weddingPlanner.entites.CheckListCategory;
import com.flawless.backend.weddingPlanner.entites.Users;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


public class CheckListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String toDo;
    private String description;
    private Instant tillDate;
    private Boolean done;
    private UsersDTO user;
    private Set<CheckListCategoryDTO> categorias = new HashSet<>();

    public CheckListDTO(){
    }
    public CheckListDTO(String id, String toDo, String description, Instant tillDate, Boolean done) {
        this.id = id;
        this.toDo = toDo;
        this.description = description;
        this.tillDate = tillDate;
        this.done = done;
    }
    public CheckListDTO(String id, String toDo, String description, Instant tillDate, Boolean done, UsersDTO user) {
        this.id = id;
        this.toDo = toDo;
        this.description = description;
        this.tillDate = tillDate;
        this.done = done;
        this.user = user;
    }
    public CheckListDTO(CheckList entity){
        id = entity.getId();
        toDo = entity.getToDo();
        description = entity.getDescription();;
        tillDate = entity.getTillDate();
        done = entity.getDone();
    }
    public CheckListDTO(CheckList entity, Set<CheckListCategory> categorias){
        this(entity);
        categorias.forEach(cat -> this.categorias.add(new CheckListCategoryDTO(cat)));
    }
    public CheckListDTO(CheckList entity, Users user, Set<CheckListCategory> categorias){
        this(entity);
        this.user = new UsersDTO(user);
        categorias.forEach(cat -> this.categorias.add(new CheckListCategoryDTO(cat)));
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getTillDate() {
        return tillDate;
    }

    public void setTillDate(Instant tillDate) {
        this.tillDate = tillDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public UsersDTO getUser() {
        return user;
    }

    public void setUserDTO(UsersDTO user) {
        this.user = user;
    }

    public Set<CheckListCategoryDTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<CheckListCategoryDTO> categoria) {
        this.categorias = categoria;
    }
}