package com.flawless.backend.weddingPlanner.controller;

import com.flawless.backend.weddingPlanner.dto.CheckListCategoryDTO;
import com.flawless.backend.weddingPlanner.services.CheckListCategoryServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/category/checklist")
public class CheckListCategoryController {

    @Autowired
    private CheckListCategoryServices service;

    @GetMapping
    public ResponseEntity<List<CheckListCategoryDTO>> findAll(
    ){
        List<CheckListCategoryDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity <CheckListCategoryDTO> findById(@PathVariable String id){
        CheckListCategoryDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<CheckListCategoryDTO> insert(@Valid @RequestBody CheckListCategoryDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CheckListCategoryDTO> update(@PathVariable String id, @Valid @RequestBody CheckListCategoryDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CheckListCategoryDTO> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
