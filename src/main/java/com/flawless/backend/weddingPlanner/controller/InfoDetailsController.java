package com.flawless.backend.weddingPlanner.controller;

import com.flawless.backend.weddingPlanner.dto.InfoDetailsDTO;
import com.flawless.backend.weddingPlanner.services.InfoDetailsServices;
import com.flawless.backend.weddingPlanner.services.UsersServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping(value = "/info")
@RestController
public class InfoDetailsController {

    @Autowired
    private InfoDetailsServices infoDetailsServices;
    @Autowired
    private UsersServices userSevice;

    @GetMapping
    public ResponseEntity<List<InfoDetailsDTO>> findAll(
    ){
        List<InfoDetailsDTO> list = infoDetailsServices.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<InfoDetailsDTO> findById(@PathVariable String id){
        InfoDetailsDTO dto = infoDetailsServices.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping
    public ResponseEntity<InfoDetailsDTO> insert(@Valid @RequestBody InfoDetailsDTO dto){
        dto = infoDetailsServices.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<InfoDetailsDTO> update(@PathVariable String id, @Valid @RequestBody InfoDetailsDTO dto){
        dto = infoDetailsServices.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteInfoDetails(@PathVariable String id) {
        infoDetailsServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
