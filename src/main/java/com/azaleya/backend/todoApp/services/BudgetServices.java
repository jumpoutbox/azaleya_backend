package com.azaleya.backend.todoApp.services;

import com.azaleya.backend.todoApp.dto.BudgetDTO;
import com.azaleya.backend.todoApp.entites.Budget;
import com.azaleya.backend.todoApp.entites.Users;
import com.azaleya.backend.todoApp.repository.BudgetRepository;
import com.azaleya.backend.todoApp.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BudgetServices {
    @Autowired
    private BudgetRepository budgetRepository;

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
}
