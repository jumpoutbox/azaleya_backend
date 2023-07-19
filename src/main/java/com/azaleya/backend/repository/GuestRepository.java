package com.azaleya.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azaleya.backend.entites.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>{

}
