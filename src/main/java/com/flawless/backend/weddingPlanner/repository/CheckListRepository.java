package com.flawless.backend.weddingPlanner.repository;

import com.flawless.backend.weddingPlanner.entites.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListRepository extends JpaRepository<CheckList, String> {

}
