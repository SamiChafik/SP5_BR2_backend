package com.example.budget_manager.services;

import com.example.budget_manager.dto.BudgetDTO;
import com.example.budget_manager.entities.Budget;
import com.example.budget_manager.mapper.BudgetMapper;
import com.example.budget_manager.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
//@Transactional
public class BudgetService {
    private final BudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository, BudgetMapper budgetMapper) {
        this.budgetRepository = budgetRepository;
        this.budgetMapper = budgetMapper;
    }



    public List<BudgetDTO> getAllBudgets() {
        return budgetRepository.findAll()
                .stream()
                .map(budgetMapper::toDTO)
                .toList();
    }

    public BudgetDTO createBudget(BudgetDTO budgetDTO) {
        Budget budget = budgetMapper.toEntity(budgetDTO);
        return budgetMapper.toDTO(budgetRepository.save(budget));
    }

    @Transactional
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}