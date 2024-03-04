package com.flawless.backend.weddingPlanner.dto;

import com.flawless.backend.weddingPlanner.entites.Guest;
import com.flawless.backend.weddingPlanner.entites.Mesas;
import com.flawless.backend.weddingPlanner.entites.Users;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MesasDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;

    private UsersDTO user;

    private Set<GuestDTO> guests = new HashSet<>();

    public MesasDTO(){}
    public MesasDTO(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public MesasDTO(Mesas mesas){
        id = mesas.getId();
        nome = mesas.getNome();
    }

    public MesasDTO(Mesas mesas, Users user){
        this(mesas);
        this.user = new UsersDTO(user);
    }

    public MesasDTO(Mesas mesas, Set<Guest> guests, Users user){
        this(mesas);
        guests.forEach(guest -> this.guests.add(new GuestDTO(guest)));
        this.user = new UsersDTO(user);
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

    public UsersDTO getUser() {
        return user;
    }

    public void setUser(UsersDTO user) {
        this.user = user;
    }

    public Set<GuestDTO> getGuests() {
        return guests;
    }

    public void setGuests(Set<GuestDTO> guests) {
        this.guests = guests;
    }
}
