package com.flawless.backend.weddingPlanner.services;


import java.util.Optional;

import com.flawless.backend.weddingPlanner.entites.Mesas;
import com.flawless.backend.weddingPlanner.repository.MesasRepository;
import com.flawless.backend.weddingPlanner.dto.GuestDTO;
import com.flawless.backend.weddingPlanner.entites.Guest;
import com.flawless.backend.weddingPlanner.repository.GuestRepository;
import com.flawless.backend.weddingPlanner.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flawless.backend.weddingPlanner.services.exception.DataBaseException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GuestServices {
	@Autowired
	GuestRepository repository;

	@Autowired
	MesasRepository mesaRepository;
	
	@Transactional(readOnly = true)
	public Page<GuestDTO> FindAllPaged(PageRequest pageRequest){
		Page<Guest> list = repository.findAll(pageRequest);
		return list.map(x->listMap(x));
	}
	@Transactional(readOnly = true)
	public GuestDTO findByID(String id) {
		Optional<Guest> guest = repository.findById(id);
		Guest entity=guest.orElseThrow(()->new ResourceNotFoundException("Guest not found"));
		if(entity.getMesa() != null){
			return new GuestDTO(entity, entity.getMesa());
		}
		return new GuestDTO(entity);
	}
	@Transactional
	public GuestDTO insertGuest(GuestDTO guest) {
		Guest entity= new Guest();
		entity.setName(guest.getName());
		entity.setConfirmation(guest.getConfirmation());
		if(guest.getMesa() != null){
			Mesas mesa = mesaRepository.getOne(guest.getMesa().getId());
			entity.setMesa(mesa);
		}
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

	private GuestDTO listMap(Guest guest){
		if(guest.getMesa() != null){
			return new GuestDTO(guest, guest.getMesa());
		}
		return new GuestDTO(guest);
	}
}
