package com.azaleya.backend.weddingPlanner.repository;

import com.azaleya.backend.weddingPlanner.entites.Mesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesasRepository extends JpaRepository<Mesas, String> {
}
