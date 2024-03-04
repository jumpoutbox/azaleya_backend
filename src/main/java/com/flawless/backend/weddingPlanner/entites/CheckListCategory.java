package com.flawless.backend.weddingPlanner.entites;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_checklistCategoria")
@EqualsAndHashCode(of = "id")
public class CheckListCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private String id;
    private String nome;

    @ManyToMany(mappedBy = "categoria")
    private Set<CheckList> checklist = new HashSet<>();

    public CheckListCategory(){}

    public CheckListCategory(String id, String nome, Set<CheckList> checklist) {
        this.id = id;
        this.nome = nome;
        this.checklist = checklist;
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

    public Set<CheckList> getChecklist() {
        return checklist;
    }
}
