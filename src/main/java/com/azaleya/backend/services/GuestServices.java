package com.azaleya.backend.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azaleya.backend.dto.GuestDTO;
import com.azaleya.backend.dto.UsersDTO;
import com.azaleya.backend.entites.Guest;
import com.azaleya.backend.repository.GuestRepository;
import com.azaleya.backend.services.exception.DataBaseException;
import com.azaleya.backend.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GuestServices {
	@Autowired
	GuestRepository repository;
	
	@Transactional(readOnly = true)
	public Page<GuestDTO> FindAllPaged(PageRequest pageRequest){
		Page<Guest> list = repository.findAll(pageRequest);
		return list.map(x->new GuestDTO(x));
	}
	@Transactional(readOnly = true)
	public GuestDTO findByID(String id) {
		Optional<Guest> guest = repository.findById(id);
		Guest entity=guest.orElseThrow(()->new ResourceNotFoundException("Guest not found"));
		return new GuestDTO(entity);
	}
	@Transactional
	public GuestDTO insertGuest(GuestDTO guest) {
		Guest entity= new Guest();
		entity.setName(guest.getName());
		entity.setConfirmation(guest.getConfirmation());
		entity=repository.save(entity);
		return new GuestDTO(entity);
	}
	@Transactional
	public GuestDTO update(String id, GuestDTO guest) {
		try {
			Guest entity = repository.getOne(id);
			entity.setName(guest.getName());
			entity.setConfirmation(guest.getConfirmation());
			entity=repository.save(entity);
			return new  GuestDTO(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found "+id);
		}
	}
	@Transactional
	public void delete(String id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found "+id);
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Violação de integridade");
		}
	}
}
