package com.flawless.backend.weddingPlanner.repository;

import com.flawless.backend.weddingPlanner.entites.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String>{

}
