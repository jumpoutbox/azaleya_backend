package com.flawless.backend.ecommerce.controller;

import com.flawless.backend.ecommerce.dto.ImagesDTO;
import com.flawless.backend.ecommerce.services.ImagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping(value = "/img")
@RestController
public class ImgController {
    @Autowired
    ImagesServices service;
    @GetMapping
    public ResponseEntity<Page<ImagesDTO>> find(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
                                                @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                @RequestParam(value = "orderBy", defaultValue = "url") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<ImagesDTO> list = service.findall(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity<ImagesDTO> findbyID(@PathVariable String id){
        ImagesDTO list = service.findById(id);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ImagesDTO> saveo(@RequestBody ImagesDTO dto){
        dto=service.saveImage(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ImagesDTO> editEndereco(@RequestBody ImagesDTO dto,@PathVariable("id") String id){
        dto=service.updateImages(id,dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        service.deleteImg(id);
        return ResponseEntity.noContent().build();
    }
}
