package com.azaleya.backend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.azaleya.backend.dto.UsersDTO;
import com.azaleya.backend.entites.Users;
import com.azaleya.backend.services.UsersServices;

@RequestMapping(value = "/user")
@RestController
public class UsersController {
	@Autowired
	private UsersServices services;
	
	@GetMapping
	public ResponseEntity<List<UsersDTO>>findAll(){
		List<UsersDTO> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UsersDTO> findByID(@PathVariable Long id){
		
		UsersDTO dto = services.findByID(id);
		return ResponseEntity.ok(dto);
	}
	@PostMapping(value = "/user")
	public ResponseEntity<UsersDTO> insertUsers(@RequestBody UsersDTO users){
		users=services.insertUsers(users);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(users.getId()).toUri();
		return ResponseEntity.created(uri).body(users);
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<UsersDTO> putUser(@PathVariable Long id, @RequestBody UsersDTO dto){
		dto=services.update(id,dto);
		return ResponseEntity.ok().body(dto);
	}
}

