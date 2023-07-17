package com.azaleya.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.azaleya.backend.dto.UsersDTO;
import com.azaleya.backend.entites.Users;
import com.azaleya.backend.repository.UsersRepository;
import com.azaleya.backend.services.exception.DataBaseException;
import com.azaleya.backend.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsersServices {
	@Autowired
	private UsersRepository repository;
	
	@Transactional(readOnly= true)
	public Page<UsersDTO> findAllPaged(PageRequest pageRequest){
		Page<Users> list_ = repository.findAll(pageRequest);
		
		return list_.map(x->new UsersDTO(x));
		
		/*Page<UsersDTO> listDao = new ArrayList<>();
		for(Users user:list_) {
			listDao.add(new UsersDTO(user));
		}
		
		return listDao;*/
	}
	@Transactional(readOnly = true)
	public UsersDTO findByID(Long id) {
		Optional<Users> user= repository.findById(id);
		Users entity = user.orElseThrow(()->new com.azaleya.backend.services.exception.ResourceNotFoundException("Usuario Não encontrado"));
		return new UsersDTO(entity);
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
	public UsersDTO update(Long id, UsersDTO user) {
		try {
			Users entity = repository.getOne(id);
			entity.setNome(user.getNome());
			entity.setEmail(user.getEmail());
			entity.setTelefone(user.getTelefone());
			entity.setNome_parceiro(user.getNome_parceiro());
			entity=repository.save(entity);
			return new UsersDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		
	}
	@Transactional
	public void delete(Long id) {
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
