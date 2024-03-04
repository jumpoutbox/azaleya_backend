package com.flawless.backend.weddingPlanner.entites;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_mesas")
@EqualsAndHashCode(of = "id")
public class Mesas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private String id;
    private String nome;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Users user;

    @OneToMany(mappedBy="mesa")
    private Set<Guest> guests = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "mesa_categoria_id")
    private MesasCategory mesasCategoria;

    public Mesas(){}

    public Mesas(String id, String nome) {
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
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
    public Set<Guest> getGuests() {
        return guests;
    }
    public void setGuests(Set<Guest> guests) {
        this.guests = guests;
    }

    public MesasCategory getMesasCategoria() {
        return mesasCategoria;
    }

    public void setMesasCategoria(MesasCategory mesasCategoria) {
        this.mesasCategoria = mesasCategoria;
    }
}
