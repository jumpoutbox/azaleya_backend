package com.azaleya.backend.weddingPlanner.repository;

import com.azaleya.backend.weddingPlanner.entites.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckListRepository extends JpaRepository<CheckList, String> {

}
