package com.azaleya.backend.weddingPlanner.controller;

import com.azaleya.backend.weddingPlanner.dto.CheckListDTO;
import com.azaleya.backend.weddingPlanner.dto.GuestDTO;
import com.azaleya.backend.weddingPlanner.entites.Guest;
import com.azaleya.backend.weddingPlanner.services.GuestServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping(value = "/guest")
@RestController
public class GuestController {
	@Autowired
	private GuestServices service;

	@GetMapping
	public ResponseEntity<Page<GuestDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                  @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
                                                  @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                  @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		Page<GuestDTO> list = service.FindAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	@GetMapping("/{id}")
	public ResponseEntity<GuestDTO> findById(@PathVariable String id){
		GuestDTO guest = service.findByID(id);
		return ResponseEntity.ok().body(guest);
	}

	@PostMapping
	public ResponseEntity<GuestDTO> insert(@Valid @RequestBody GuestDTO dto){
		dto = service.insertGuest(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<GuestDTO> update(@PathVariable String id, @Valid @RequestBody GuestDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<GuestDTO> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
