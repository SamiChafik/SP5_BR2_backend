package com.example.budget_manager.mapper;

import com.example.budget_manager.dto.BudgetDTO;
import com.example.budget_manager.entities.Budget;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BudgetMapper {
    BudgetDTO toDTO(Budget budget);
    Budget toEntity(BudgetDTO budgetDTO);
}