package com.azaleya.backend.todoApp.controller;

import com.azaleya.backend.todoApp.dto.UsersDTO;
import com.azaleya.backend.todoApp.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/user")
@RestController
public class UsersController {
	@Autowired
	private UsersServices services;

	@GetMapping
	public ResponseEntity<Page<UsersDTO>>findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
			){

		PageRequest pageRequest=PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		Page<UsersDTO> list = services.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsersDTO> findByID(@PathVariable String id) {

		UsersDTO dto = services.findByID(id);
		return ResponseEntity.ok(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UsersDTO> updateUser(@PathVariable String id, @RequestBody UsersDTO dto) {
		dto = services.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
}
