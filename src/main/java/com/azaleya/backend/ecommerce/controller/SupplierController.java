package com.azaleya.backend.ecommerce.controller;

import java.net.URI;
import java.util.Optional;

import com.azaleya.backend.ecommerce.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.azaleya.backend.ecommerce.dto.SupplierDTO;
import com.azaleya.backend.ecommerce.services.SupplierServices;

@RequestMapping(value = "/supplier")
@RestController
public class SupplierController {
	@Autowired
	private SupplierServices services;

	@GetMapping
	public ResponseEntity<Page<SupplierDTO>> find(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<SupplierDTO> list = services.FindPage(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<SupplierDTO> findId(@PathVariable("id") String id ){
		SupplierDTO object = services.FIndByID(id);
		return ResponseEntity.ok().body(object);
	}
	@PostMapping
	public ResponseEntity<SupplierDTO> inserir(@RequestBody SupplierDTO dto){
		dto = services.saveSupplier(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<SupplierDTO> update(@PathVariable("id") String id, @RequestBody SupplierDTO dto ){
		dto = services.updteSupplier(dto, id);
		return ResponseEntity.ok(dto);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		services.deleteSupplier(id);
		return ResponseEntity.noContent().build();
	}
}
