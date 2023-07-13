package com.azaleya.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azaleya.backend.dto.UsersDTO;
import com.azaleya.backend.entites.Users;
import com.azaleya.backend.repository.UsersRepository;

@Service
public class UsersServices {
	@Autowired
	private UsersRepository repository;
	
	@Transactional(readOnly= true)
	public List<UsersDTO> findAll(){
		List<Users> list_ = repository.findAll();
		
		List<UsersDTO> listDao = new ArrayList<>();
		for(Users user:list_) {
			listDao.add(new UsersDTO(user));
		}
		
		return listDao;
	}
	@Transactional(readOnly = true)
	public UsersDTO findByID(Long id) {
		Optional<Users> user= repository.findById(id);
		Users entity = user.get();
		return new UsersDTO(entity);
	}
	
}
