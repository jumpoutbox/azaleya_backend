package com.azaleya.backend.weddingPlanner.entites;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_mesasCategoria")
@EqualsAndHashCode(of = "id")
public class MesasCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;

    @OneToMany(mappedBy="mesasCategoria")
    private Set<Mesas> mesas  = new HashSet<>();

    public MesasCategory(){}

    public MesasCategory(String id, String nome, Set<Mesas> mesas) {
        this.id = id;
        this.nome = nome;
        this.mesas = mesas;
    }

    public MesasCategory(String id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Set<Mesas> getMesas() {
        return mesas;
    }

    public void setMesas(Set<Mesas> mesas) {
        this.mesas = mesas;
    }
}
