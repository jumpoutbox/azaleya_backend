package com.flawless.backend.weddingPlanner.repository;

import com.flawless.backend.weddingPlanner.entites.MesasCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesasCategoryRepository extends JpaRepository<MesasCategory, String> {
}
