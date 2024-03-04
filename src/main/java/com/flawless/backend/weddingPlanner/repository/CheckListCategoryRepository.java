package com.flawless.backend.weddingPlanner.repository;

import com.flawless.backend.weddingPlanner.entites.CheckListCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListCategoryRepository extends JpaRepository<CheckListCategory, String> {
}
