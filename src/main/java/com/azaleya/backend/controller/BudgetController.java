package com.azaleya.backend.controller;

import com.azaleya.backend.dto.BudgetDTO;
import com.azaleya.backend.services.BudgetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/budget")
@RestController
public class BudgetController {

    @Autowired
    private BudgetServices budgetServices;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BudgetDTO> findById(@PathVariable String id){
        BudgetDTO dto = budgetServices.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
