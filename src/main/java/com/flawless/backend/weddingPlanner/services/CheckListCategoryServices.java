package com.flawless.backend.weddingPlanner.services;

import com.flawless.backend.weddingPlanner.dto.CheckListCategoryDTO;
import com.flawless.backend.weddingPlanner.entites.CheckListCategory;
import com.flawless.backend.weddingPlanner.repository.CheckListCategoryRepository;
import com.flawless.backend.weddingPlanner.services.exception.DataBaseException;
import com.flawless.backend.weddingPlanner.services.exception.ResourceNotFoundException;
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
public class CheckListCategoryServices {

    @Autowired
    private CheckListCategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CheckListCategoryDTO> findAll(){
        List<CheckListCategory> list = repository.findAll();
        return list.stream().map(x -> new CheckListCategoryDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CheckListCategoryDTO findById(String id){
        Optional<CheckListCategory> obj = repository.findById(id);
        CheckListCategory entity = obj.orElseThrow(()->new ResourceNotFoundException("Entity not found!"));
        //return new CheckListDTO(entity, entity.getCategories());
        return new CheckListCategoryDTO(entity);
    }

    @Transactional
    public CheckListCategoryDTO insert(CheckListCategoryDTO dto) {
        CheckListCategory entity = new CheckListCategory();
        entity.setNome(dto.getNome());
        entity = repository.save(entity);

        return new CheckListCategoryDTO(entity);
    }

    @Transactional
    public CheckListCategoryDTO update(String id, CheckListCategoryDTO dto) {
        try{
            CheckListCategory entity = repository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity = repository.save(entity);
            return new CheckListCategoryDTO(entity);
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
