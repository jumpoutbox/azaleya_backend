package com.flawless.backend.weddingPlanner.services;

import com.flawless.backend.weddingPlanner.dto.BudgetDTO;
import com.flawless.backend.weddingPlanner.entites.Budget;
import com.flawless.backend.weddingPlanner.entites.Users;
import com.flawless.backend.weddingPlanner.repository.BudgetRepository;
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
public class BudgetServices {
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private AuthorizationService authService;

    @Transactional(readOnly = true)
    public List<BudgetDTO> findAll(){
        List<Budget> list = budgetRepository.findAll();
        return list.stream().map(x -> new BudgetDTO(x)).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public BudgetDTO findById(String id){
        Optional<Budget> obj = budgetRepository.findById(id);
        Budget entity = obj.orElseThrow(()->new ResourceNotFoundException("Entity not found!"));
        return new BudgetDTO(entity);
    }
    @Transactional
    public BudgetDTO insert(BudgetDTO dto) {
        Budget entity = new Budget();
        entity.setBudget(dto.getBudget());
        entity.setUser(authService.authenticated());
        entity = budgetRepository.save(entity);
        return new BudgetDTO(entity);
    }
    @Transactional
    public BudgetDTO update(String id, BudgetDTO dto) {
        try{
            Budget entity = budgetRepository.getReferenceById(id);
            entity.setBudget(dto.getBudget());
            entity = budgetRepository.save(entity);
            return new BudgetDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found "+ id);
        }
    }

    @Transactional
    public void delete(String id) {
        try {
            budgetRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found "+id);
        }
        catch(DataIntegrityViolationException e) {
            throw new DataBaseException("Violação de integridade!");
        }
    }
}
