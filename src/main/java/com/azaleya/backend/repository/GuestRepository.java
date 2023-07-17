package com.azaleya.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azaleya.backend.entites.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{

}
