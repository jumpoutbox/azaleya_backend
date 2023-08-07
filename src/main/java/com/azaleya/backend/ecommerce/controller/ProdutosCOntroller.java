package com.azaleya.backend.ecommerce.controller;

import com.azaleya.backend.ecommerce.dto.EnderecoDTO;
import com.azaleya.backend.ecommerce.dto.ProdutoDTO;
import com.azaleya.backend.ecommerce.services.EnderecoService;
import com.azaleya.backend.ecommerce.services.ProdutosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@RequestMapping(value = "/produto")
@RestController
public class ProdutosCOntroller {
    @Autowired
    ProdutosServices service;

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> find(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
                                                 @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                 @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<ProdutoDTO> list = service.findPage(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity<ProdutoDTO> findbyID(@PathVariable String id){
        ProdutoDTO list = service.findByID(id);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> saveEndereco(@RequestBody ProdutoDTO dto){
        dto=service.saveProduto(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> edit(@RequestBody ProdutoDTO dto,@PathVariable("id") String id){
        dto=service.updateProduto(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
