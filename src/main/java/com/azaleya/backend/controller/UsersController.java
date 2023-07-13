package com.azaleya.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azaleya.backend.dto.UsersDTO;
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
}

