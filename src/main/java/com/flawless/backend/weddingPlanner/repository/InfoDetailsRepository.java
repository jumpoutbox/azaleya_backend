package com.flawless.backend.weddingPlanner.repository;

import com.flawless.backend.weddingPlanner.entites.Budget;
import com.flawless.backend.weddingPlanner.entites.InfoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoDetailsRepository extends JpaRepository<InfoDetails, String> {
}
