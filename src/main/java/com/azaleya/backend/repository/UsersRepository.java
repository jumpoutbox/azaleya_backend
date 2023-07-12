package com.azaleya.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azaleya.backend.entites.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
