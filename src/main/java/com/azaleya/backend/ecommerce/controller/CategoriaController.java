package com.azaleya.backend.ecommerce.controller;

import com.azaleya.backend.ecommerce.dto.CategoriaDTO;
import com.azaleya.backend.ecommerce.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping(value = "/categoria")
@RestController
public class CategoriaController {
    @Autowired
    CategoriaServices service;
    @GetMapping
    public ResponseEntity<Page<CategoriaDTO>> find(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                   @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
                                                   @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                   @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<CategoriaDTO> list = service.findall(pageRequest);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value= "/{id}")
    public ResponseEntity<CategoriaDTO> findbyID(@PathVariable String id){
        CategoriaDTO list = service.FindByID(id);
        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO dto){
        dto=service.saveCategoria(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO dto,@PathVariable("id") String id){
        dto=service.updateCategoria(dto,id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        service.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
