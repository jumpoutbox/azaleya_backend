package com.azaleya.backend.weddingPlanner.controller;

import com.azaleya.backend.weddingPlanner.dto.MesasDTO;
import com.azaleya.backend.weddingPlanner.services.MesasServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping(value = "/mesas")
@RestController
public class MesasController {

    @Autowired
    MesasServices service;

    @GetMapping
    public ResponseEntity<List<MesasDTO>> findAll(
    ){
        List<MesasDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity <MesasDTO> findById(@PathVariable String id){
        MesasDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<MesasDTO> insert(@Valid @RequestBody MesasDTO dto){
        dto = service.insertMesa(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<MesasDTO> update(@PathVariable String id, @Valid @RequestBody MesasDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MesasDTO> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
