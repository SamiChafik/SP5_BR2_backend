package com.example.budget_manager.controllers;

import com.example.budget_manager.dto.BudgetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.budget_manager.services.BudgetService;

import java.util.List;

@RestController


public class BudgetController {

    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }


    @GetMapping("/budget")
    public List<BudgetDTO> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    @PostMapping("/budget")
    public BudgetDTO createBudget(@RequestBody BudgetDTO budgetDTO) {
        return budgetService.createBudget(budgetDTO);
    }

    @DeleteMapping("/budget/{id}")
    public void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
    }
}