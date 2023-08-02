package com.azaleya.backend.weddingPlanner.services;

import com.azaleya.backend.weddingPlanner.dto.MesasCategoryDTO;
import com.azaleya.backend.weddingPlanner.entites.MesasCategory;
import com.azaleya.backend.weddingPlanner.repository.MesasCategoryRepository;
import com.azaleya.backend.weddingPlanner.services.exception.DataBaseException;
import com.azaleya.backend.weddingPlanner.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MesasCategoryServices {
    @Autowired
    private MesasCategoryRepository repository;

    @Transactional(readOnly = true)
    public List<MesasCategoryDTO> findAll(){
        List<MesasCategory> list = repository.findAll();
        return list.stream().map(x -> new MesasCategoryDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MesasCategoryDTO findById(String id){
        Optional<MesasCategory> obj = repository.findById(id);
        MesasCategory entity = obj.orElseThrow(()->new ResourceNotFoundException("Entity not found!"));
        //return new CheckListDTO(entity, entity.getCategories());
        return new MesasCategoryDTO(entity);
    }

    @Transactional
    public MesasCategoryDTO insert(MesasCategoryDTO dto) {
        MesasCategory entity = new MesasCategory();
        entity.setNome(dto.getNome());
        entity = repository.save(entity);

        return new MesasCategoryDTO(entity);
    }

    @Transactional
    public MesasCategoryDTO update(String id, MesasCategoryDTO dto) {
        try{
            MesasCategory entity = repository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity = repository.save(entity);
            return new MesasCategoryDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found "+ id);
        }
    }

    public void delete(String id) {
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found "+id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException("Integrity Violation");
        }
    }
}
