package com.entreprise.mpa.service;

import com.entreprise.mpa.entity.MonthlyExpenseBudget;
import com.entreprise.mpa.repository.MonthlyExpenseBudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthlyExpenseBudgetService {

    private final MonthlyExpenseBudgetRepository repo;

    public MonthlyExpenseBudgetService(MonthlyExpenseBudgetRepository repo) {
        this.repo = repo;
    }

    public List<MonthlyExpenseBudget> getAll() {
        return repo.findAll();
    }

    public MonthlyExpenseBudget getByMonth(String month) {
        return repo.findByMonth(month).orElse(null);
    }

    public MonthlyExpenseBudget saveOrUpdate(MonthlyExpenseBudget budget) {
        MonthlyExpenseBudget existing = repo.findByMonth(budget.getMonth()).orElse(null);

        if (existing != null) {
            existing.setAmount(budget.getAmount());
            existing.setCurrency(budget.getCurrency());
            return repo.save(existing);
        }

        return repo.save(budget);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}