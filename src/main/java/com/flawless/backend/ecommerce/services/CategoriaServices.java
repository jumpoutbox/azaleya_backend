package com.flawless.backend.ecommerce.services;

import com.flawless.backend.ecommerce.Repository.CategoriaRepository;
import com.flawless.backend.ecommerce.dto.CategoriaDTO;
import com.flawless.backend.ecommerce.entities.Categoria;
import com.flawless.backend.weddingPlanner.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoriaServices {
    @Autowired
    CategoriaRepository repository;
    @Transactional(readOnly = true)
    public Page<CategoriaDTO> findall(PageRequest pageRequest){
        Page<Categoria>list = repository.findAll(pageRequest);
        return list.map(x->new CategoriaDTO(x));
    }
    @Transactional(readOnly = true)
    public CategoriaDTO FindByID(String id){
        Optional<Categoria> find = repository.findById(id);
        Categoria entity=find.orElseThrow(()->new ResourceNotFoundException("Erro"));
        return new CategoriaDTO(entity);
    }
    @Transactional
    public CategoriaDTO saveCategoria(CategoriaDTO categoria){
        Categoria entity = new Categoria();
        entity.setNome(categoria.getNome());
        entity.setDescricacao(categoria.getDescricacao());
        entity=repository.save(entity);
        return new CategoriaDTO(entity);
    }
    @Transactional
    public CategoriaDTO updateCategoria(CategoriaDTO dto, String id){
        try {
            Categoria entity = repository.getReferenceById(id);

            entity.setNome(dto.getNome());
            entity.setDescricacao(dto.getDescricacao());
            entity=repository.save(entity);
            return new CategoriaDTO(entity);
        }catch (Exception e){
            throw new ResourceNotFoundException("Erro a encontrar a categoria");
        }
    }
    @Transactional
    public void deleteCategoria(String id){
        try {
            repository.deleteById(id);
        }catch (Exception e){
            throw new ResourceNotFoundException("Erro a deletar");
        }
    }
}
