package com.flawless.backend.weddingPlanner.controller;

import com.flawless.backend.weddingPlanner.dto.BudgetDTO;
import com.flawless.backend.weddingPlanner.services.BudgetServices;
import com.flawless.backend.weddingPlanner.services.UsersServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping(value = "/budget")
@RestController
public class BudgetController {

    @Autowired
    private BudgetServices budgetServices;
    @Autowired
    private UsersServices userSevice;

    @GetMapping
    public ResponseEntity<List<BudgetDTO>> findAll(
    ){
        List<BudgetDTO> list = budgetServices.findAll();
        return ResponseEntity.ok().body(list);
    }
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
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable String id) {
        budgetServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
