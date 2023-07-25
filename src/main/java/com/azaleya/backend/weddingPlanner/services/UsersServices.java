package com.azaleya.backend.weddingPlanner.services;


import java.util.Optional;

import com.azaleya.backend.weddingPlanner.entites.Budget;
import com.azaleya.backend.weddingPlanner.repository.UsersRepository;
import com.azaleya.backend.weddingPlanner.services.exception.DataBaseException;
import com.azaleya.backend.weddingPlanner.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.azaleya.backend.weddingPlanner.dto.UsersDTO;
import com.azaleya.backend.weddingPlanner.entites.Users;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsersServices {
	@Autowired
	private UsersRepository repository;

	@Transactional(readOnly= true)
	public Page<UsersDTO> findAllPaged(PageRequest pageRequest){
		Page<Users> list_ = repository.findAll(pageRequest);
		return list_.map(x->new UsersDTO(x));
	}
	@Transactional(readOnly = true)
	public UsersDTO findByID(String id) {
		Optional<Users> user= repository.findById(id);
		Users entity = user.orElseThrow(()->new ResourceNotFoundException("Usuario Não encontrado"));
		return new UsersDTO(entity, entity.getToDoList().stream().toList());
	}
	@Transactional
	public UsersDTO insertUsers(UsersDTO user) {
		Users entity = new Users();
		entity.setNome(user.getNome());
		entity.setEmail(user.getEmail());
		entity.setTelefone(user.getTelefone());
		entity.setNome_parceiro(user.getNome_parceiro());
		entity=repository.save(entity);
		return new UsersDTO(entity);
	}
	@Transactional
	public UsersDTO update(String id, UsersDTO user) {
		try {
			Users entity = repository.getReferenceById(id);
			entity.setNome(user.getNome());
			entity.setEmail(user.getEmail());
			entity.setTelefone(user.getTelefone());
			entity.setNome_parceiro(user.getNome_parceiro());
			entity.setBudget(new Budget(user.getBudget()));
			entity=repository.save(entity);
			return new UsersDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	@Transactional
	public void delete(String id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found "+id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Violação de integridade!");
		}
	}

}
