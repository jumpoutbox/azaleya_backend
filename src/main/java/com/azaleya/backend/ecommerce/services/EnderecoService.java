package com.azaleya.backend.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azaleya.backend.ecommerce.Repository.EnderecoRepository;
import com.azaleya.backend.ecommerce.Repository.SupplierRepository;
import com.azaleya.backend.ecommerce.dto.EnderecoDTO;
import com.azaleya.backend.ecommerce.entities.Endereco;
import com.azaleya.backend.weddingPlanner.services.exception.ResourceNotFoundException;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository repository;
	@Autowired
	SupplierRepository supplierRepository;

	@Transactional(readOnly = true)
	public Page<EnderecoDTO> FindPage(PageRequest pageRequest) {
		Page<Endereco> list = repository.findAll(pageRequest);
		return list.map(x -> new EnderecoDTO(x));
	}

	@Transactional
	public EnderecoDTO saveEndereco(EnderecoDTO dto, Long id) {

		Endereco SuplierID= supplierRepository.findById(id).map(supplier -> {
			Endereco ende= new Endereco();
			dto.setSupplier(supplier);
			ende.setSupplier(dto.getSupplier());
			repository.save(ende);

			return new Endereco();

		}).orElseThrow();
		
		/*Endereco endereco = repository2.findById(id).map(supplier->{
			dto.setSupplier(supplier);
			dto=repository.save(dto);

		}).orElseThrow();*/
		
		return new EnderecoDTO(SuplierID);
		
	}

	@Transactional
	public EnderecoDTO updateEndereco(EnderecoDTO dto, Long id) {
		try {
			Endereco endereco = repository.getOne(id);
			endereco.setEndereco(dto.getEndereco());
			endereco.setProvincia(dto.getProvincia());
			endereco.setTelefone(dto.getTelefone());
			endereco.setSupplier(dto.getSupplier());
			endereco = repository.save(endereco);
			return new EnderecoDTO(endereco);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Erro");
		}

	}

	@Transactional
	public void deleteEndereco(Long id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Naõ podes deletar um fornecedor que na existite");
		}

	}
}
