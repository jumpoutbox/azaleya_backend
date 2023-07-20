package com.azaleya.backend.weddingPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.azaleya.backend.weddingPlanner.entites.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    UserDetails findByEmail(String email);

}
