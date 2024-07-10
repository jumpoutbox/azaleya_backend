package com.flawless.backend.weddingPlanner.services;


import java.util.Optional;

import com.flawless.backend.weddingPlanner.entites.Budget;
import com.flawless.backend.weddingPlanner.helper.UserCreatedEvent;
import com.flawless.backend.weddingPlanner.repository.UsersRepository;
import com.flawless.backend.weddingPlanner.services.exception.DataBaseException;
import com.flawless.backend.weddingPlanner.services.exception.ResourceNotFoundException;
import com.flawless.backend.weddingPlanner.dto.UsersDTO;
import com.flawless.backend.weddingPlanner.entites.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsersServices {
	@Autowired
	private UsersRepository repository;

	@Autowired
	private AuthorizationService authService;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Transactional(readOnly= true)
	public Page<UsersDTO> findAllPaged(PageRequest pageRequest){
		Page<Users> listUsers = repository.findAll(pageRequest);

		return listUsers.map(UsersDTO::new);
	}
	@Transactional(readOnly = true)
	public UsersDTO findByID(String id) {
		authService.validateAdmin(id);//Testando autorização
		Optional<Users> user= repository.findById(id);
		Users entity = user.orElseThrow(()->new ResourceNotFoundException("Usuario Não encontrado"));
		if(entity.getBudget() != null){
			return new UsersDTO(entity, entity.getToDoList().stream().toList(), entity.getBudget(), entity.getInfoDetails());
		}
		return new UsersDTO(entity, entity.getToDoList().stream().toList(), entity.getInfoDetails());
	}
	@Transactional(readOnly = true)
	public UsersDTO perfil() {
		Users entity = authService.authenticated();
		if(entity.getBudget() != null){
			// Publicar o evento de criação de usuário
			eventPublisher.publishEvent(new UserCreatedEvent(this, entity));
			return new UsersDTO(entity, entity.getToDoList().stream().toList());
		}
		// Publicar o evento de criação de usuário
		eventPublisher.publishEvent(new UserCreatedEvent(this, entity));
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
