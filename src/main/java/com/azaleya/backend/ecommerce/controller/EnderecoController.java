package com.azaleya.backend.ecommerce.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.azaleya.backend.ecommerce.dto.EnderecoDTO;
import com.azaleya.backend.ecommerce.entities.Endereco;
import com.azaleya.backend.ecommerce.services.EnderecoService;

@RequestMapping(value = "/endereco")
@RestController
public class EnderecoController {
	@Autowired
	EnderecoService service;

	@GetMapping
	public ResponseEntity<Page<EnderecoDTO>> find(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "endereco") String orderBy) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<EnderecoDTO> list = service.FindPage(pageRequest);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value= "/{id}")
	public ResponseEntity<EnderecoDTO> findbyID(@PathVariable String id){
		EnderecoDTO list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<EnderecoDTO> saveEndereco(@RequestBody EnderecoDTO dto){
		dto=service.saveEndereco(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	/*@PutMapping(value = "/{id}")
	public ResponseEntity<EnderecoDTO> editEndereco(@RequestBody EnderecoDTO dto,@PathVariable("id") Long id){
		dto=service.updateEndereco(dto, id);
		return ResponseEntity.ok(dto);
	}*/

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id){
		service.deleteEndereco(id);
		return ResponseEntity.noContent().build();
	}
}
