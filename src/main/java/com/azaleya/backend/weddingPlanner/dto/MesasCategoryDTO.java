package com.azaleya.backend.weddingPlanner.dto;

import com.azaleya.backend.weddingPlanner.entites.Mesas;
import com.azaleya.backend.weddingPlanner.entites.MesasCategory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MesasCategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private Set<MesasDTO> mesas = new HashSet<>();

    public MesasCategoryDTO(){}
    public MesasCategoryDTO(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public  MesasCategoryDTO (MesasCategory entity){
        id = entity.getId();
        nome = entity.getNome();
    }

    public  MesasCategoryDTO (MesasCategory entity, List<Mesas> mesas){
        this(entity);
        mesas.forEach(mesa -> this.mesas.add(new MesasDTO(mesa)));
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

    public Set<MesasDTO> getMesaDTO() {
        return mesas;
    }

    public void setMesaDTO(Set<MesasDTO> mesaDTO) {
        this.mesas = mesaDTO;
    }
}
