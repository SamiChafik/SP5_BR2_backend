package service;

import dto.BudgetDTO;
import entity.Budget;
import lombok.RequiredArgsConstructor;
import mapper.BudgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BudgetRepository;

import java.util.List;

@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;

    @Autowired  // Injection des dépendances
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
        budget.setSpentAmount(0.0); // Initialisation du montant dépensé
        return budgetMapper.toDTO(budgetRepository.save(budget));
    }
}
