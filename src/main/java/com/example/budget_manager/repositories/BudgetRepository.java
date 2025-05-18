package com.example.budget_manager.repositories;

import com.example.budget_manager.entities.Budget;
import org.aspectj.apache.bcel.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BudgetRepository extends JpaRepository<Budget, Long> {
}