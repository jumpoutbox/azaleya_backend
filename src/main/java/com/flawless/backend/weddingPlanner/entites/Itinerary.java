package com.flawless.backend.weddingPlanner.entites;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_itinerary")
public class Itinerary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private String id;
}
