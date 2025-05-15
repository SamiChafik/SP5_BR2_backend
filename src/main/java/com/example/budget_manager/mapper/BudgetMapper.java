package mapper;

import dto.BudgetDTO;
import entity.Budget;


public interface BudgetMapper {
    BudgetDTO toDTO(Budget budget);
    Budget toEntity(BudgetDTO budgetDTO);
}
