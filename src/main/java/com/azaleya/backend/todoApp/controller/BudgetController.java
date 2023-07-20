package com.azaleya.backend.todoApp.controller;

import com.azaleya.backend.todoApp.dto.BudgetDTO;
import com.azaleya.backend.todoApp.services.BudgetServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
    @PostMapping
    public ResponseEntity<BudgetDTO> insert(@Valid @RequestBody BudgetDTO dto){
        dto = budgetServices.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<BudgetDTO> update(@PathVariable String id, @Valid @RequestBody BudgetDTO dto){
        dto = budgetServices.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
