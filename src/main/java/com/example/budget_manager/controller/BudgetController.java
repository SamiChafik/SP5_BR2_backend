package controller;

import dto.BudgetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.BudgetService;

import java.util.List;

@RestController


public class BudgetController {

    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }


    @GetMapping("/budgets")
    public List<BudgetDTO> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    @PostMapping("/budgets")
    public BudgetDTO createBudget(@RequestBody BudgetDTO budgetDTO) {
        return budgetService.createBudget(budgetDTO);
    }
}
