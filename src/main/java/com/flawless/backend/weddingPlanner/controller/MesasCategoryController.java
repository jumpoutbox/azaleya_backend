package com.flawless.backend.weddingPlanner.controller;

import com.flawless.backend.weddingPlanner.dto.MesasCategoryDTO;
import com.flawless.backend.weddingPlanner.services.MesasCategoryServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/category/mesas")
public class MesasCategoryController {

    @Autowired
    private MesasCategoryServices service;

    @GetMapping
    public ResponseEntity<List<MesasCategoryDTO>> findAll(
    ){
        List<MesasCategoryDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity <MesasCategoryDTO> findById(@PathVariable String id){
        MesasCategoryDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<MesasCategoryDTO> insert(@Valid @RequestBody MesasCategoryDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<MesasCategoryDTO> update(@PathVariable String id, @Valid @RequestBody MesasCategoryDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MesasCategoryDTO> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
