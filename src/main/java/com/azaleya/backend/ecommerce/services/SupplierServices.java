package com.azaleya.backend.ecommerce.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azaleya.backend.ecommerce.Repository.SupplierRepository;
import com.azaleya.backend.ecommerce.dto.SupplierDTO;
import com.azaleya.backend.ecommerce.entities.Supplier;
import com.azaleya.backend.weddingPlanner.services.exception.ResourceNotFoundException;

import java.util.Optional;

@Service
public class SupplierServices {
	@Autowired
	SupplierRepository repository;
	
	@Transactional(readOnly = true)
	public Page<SupplierDTO>FindPage(PageRequest pageRequest){
		Page<Supplier>list=repository.findAll(pageRequest);
		return list.map(x->new SupplierDTO(x));
	}
	@Transactional(readOnly = true)
	public SupplierDTO FIndByID(String id){
		Optional<Supplier> findId = repository.findById(id);
		Supplier entity = findId.orElseThrow(()->new ResourceNotFoundException("Erro"));
        return new SupplierDTO(entity);
	}
	@Transactional
	public SupplierDTO saveSupplier(SupplierDTO supplier) {
		Supplier entity = new Supplier();
		entity.setNome(supplier.getNome());
		entity.setEmail(supplier.getEmail());
		entity.setImgPerfilUrl(supplier.getImgPerfilUrl());
		entity.setNif(supplier.getNif());
		entity.setPass(supplier.getPass());
		entity= repository.save(entity);
		return new SupplierDTO(entity);
	}
	
	@Transactional
	public SupplierDTO updteSupplier(SupplierDTO dto, String id) {
		try {
			Supplier findId= repository.getReferenceById(id);
			findId.setEnderecos(dto.getEnderecos());
			findId.setNome(dto.getNome());
			findId.setPass(dto.getPass());
			findId.setNif(dto.getNif());
			findId.setEmail(dto.getEmail());
			findId.setImgPerfilUrl(dto.getImgPerfilUrl());
			findId=repository.save(findId);
			return new SupplierDTO(findId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Erro ao encontrar este fornecedor");
		}
		
	}
	@Transactional
	public void deleteSupplier(String id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Naõ podes deletar um fornecedor que na existite");
		}
	}
	
}
