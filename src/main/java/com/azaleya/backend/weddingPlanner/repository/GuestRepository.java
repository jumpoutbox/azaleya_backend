package com.azaleya.backend.weddingPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azaleya.backend.weddingPlanner.entites.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String>{

}
