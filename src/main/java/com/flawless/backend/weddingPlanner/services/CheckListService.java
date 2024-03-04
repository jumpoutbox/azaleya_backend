package com.flawless.backend.weddingPlanner.services;

import com.flawless.backend.weddingPlanner.dto.CheckListCategoryDTO;
import com.flawless.backend.weddingPlanner.dto.CheckListDTO;
import com.flawless.backend.weddingPlanner.entites.CheckList;
import com.flawless.backend.weddingPlanner.entites.CheckListCategory;
import com.flawless.backend.weddingPlanner.entites.Users;
import com.flawless.backend.weddingPlanner.repository.CheckListCategoryRepository;
import com.flawless.backend.weddingPlanner.repository.CheckListRepository;
import com.flawless.backend.weddingPlanner.repository.UsersRepository;
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
public class CheckListService {

    @Autowired
    private CheckListRepository repository;

    @Autowired
    private CheckListCategoryRepository catRepository;
    @Autowired
    private UsersRepository userRepository;

    @Transactional(readOnly = true)
    public List<CheckListDTO> findAll(){
        List<CheckList> list = repository.findAll();
        return list.stream().map(x -> new CheckListDTO(x, x.getUser(), x.getCategoria())).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CheckListDTO findById(String id){
        Optional<CheckList> obj = repository.findById(id);
        CheckList entity = obj.orElseThrow(()->new ResourceNotFoundException("Entity not found!"));
        return new CheckListDTO(entity, entity.getCategoria());
    }

   @Transactional
    public CheckListDTO insert(CheckListDTO dto) {
        CheckList entity = new CheckList();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new CheckListDTO(entity);
    }

    @Transactional
    public CheckListDTO update(String id, CheckListDTO dto) {
        try{
            CheckList entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new CheckListDTO(entity);
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

    private void copyDtoToEntity(CheckListDTO dto, CheckList entity) {
        entity.setToDo(dto.getToDo());
        entity.setTillDate(dto.getTillDate());
        entity.setDone(dto.getDone());
        Users user = userRepository.getReferenceById(dto.getUser().getId());
        entity.setUser(user);
        entity.setDescription(dto.getDescription());

        entity.getCategoria().clear();
        for(CheckListCategoryDTO catDto: dto.getCategorias()){
            CheckListCategory categoria = catRepository.getReferenceById(catDto.getId());
            entity.getCategoria().add(categoria);
        }
    }
}
