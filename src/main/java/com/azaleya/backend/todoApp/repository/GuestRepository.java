package com.azaleya.backend.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azaleya.backend.todoApp.entites.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String>{

}
