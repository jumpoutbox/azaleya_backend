package com.azaleya.backend.controller;

import java.net.URI;

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

import com.azaleya.backend.dto.UsersDTO;
import com.azaleya.backend.services.UsersServices;

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
	public ResponseEntity<UsersDTO> findByID(@PathVariable Long id) {

		UsersDTO dto = services.findByID(id);
		return ResponseEntity.ok(dto);
	}

	/*@PostMapping(value = "/user")
	public ResponseEntity<UsersDTO> insertUsers(@RequestBody UsersDTO users) {
		users = services.insertUsers(users);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(users.getId()).toUri();
		return ResponseEntity.created(uri).body(users);
	}*/

	@PutMapping(value = "/{id}")
	public ResponseEntity<UsersDTO> putUser(@PathVariable Long id, @RequestBody UsersDTO dto) {
		dto = services.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
}
