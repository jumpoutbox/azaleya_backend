package com.azaleya.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azaleya.backend.dto.GuestDTO;
import com.azaleya.backend.dto.UsersDTO;
import com.azaleya.backend.entites.Guest;
import com.azaleya.backend.services.GuestServices;

@RequestMapping(value = "/guest")
@RestController
public class GuestController {
	@Autowired
	private GuestServices service;

	@GetMapping
	public ResponseEntity<Page<GuestDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		Page<GuestDTO> list = service.FindAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);

	}
}