package com.azaleya.backend.services;

import com.azaleya.backend.dto.BudgetDTO;
import com.azaleya.backend.entites.Budget;
import com.azaleya.backend.repository.BudgetRepository;
import com.azaleya.backend.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
}
