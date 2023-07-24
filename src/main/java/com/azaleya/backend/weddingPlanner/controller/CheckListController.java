package com.azaleya.backend.weddingPlanner.controller;

import com.azaleya.backend.weddingPlanner.dto.CheckListDTO;
import com.azaleya.backend.weddingPlanner.dto.ToDoInsertDTO;
import com.azaleya.backend.weddingPlanner.entites.CheckList;
import com.azaleya.backend.weddingPlanner.services.CheckListCategoryServices;
import com.azaleya.backend.weddingPlanner.services.CheckListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/checklist")
public class CheckListController {

    @Autowired
    private CheckListCategoryServices services;

    @Autowired
    private CheckListService service;

    @GetMapping
    public ResponseEntity<List<CheckListDTO>> findAll(
    ){
        List<CheckListDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity <CheckListDTO> findById(@PathVariable String id){
        CheckListDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<CheckListDTO> insert(@Valid @RequestBody CheckListDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CheckListDTO> update(@PathVariable String id, @Valid @RequestBody CheckListDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CheckListDTO> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
