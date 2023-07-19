package com.azaleya.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.azaleya.backend.entites.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    UserDetails findByEmail(String email);

}
