package com.azaleya.backend.weddingPlanner.entites;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_mesas")
public class Mesas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private String id;
    private String nome;
}
