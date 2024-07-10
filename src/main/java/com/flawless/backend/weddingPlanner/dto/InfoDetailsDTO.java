package com.flawless.backend.weddingPlanner.dto;

import com.flawless.backend.weddingPlanner.entites.Budget;
import com.flawless.backend.weddingPlanner.entites.InfoDetails;
import com.flawless.backend.weddingPlanner.entites.Users;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class InfoDetailsDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    private LocalDate dataCasamento;

    private UsersDTO user;

    public InfoDetailsDTO(){}

    public InfoDetailsDTO(InfoDetails info){
        this.id = info.getId();
        this.dataCasamento = info.getDataCasamento();
    }

    public InfoDetailsDTO(String id, LocalDate dataCasamento){
        this.id = id;
        this.dataCasamento = dataCasamento;
    }

    public InfoDetailsDTO(InfoDetails entity, Users user) {
        this(entity);
        this.user = new UsersDTO(user);
    }
}
