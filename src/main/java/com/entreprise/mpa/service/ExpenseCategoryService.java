package com.entreprise.mpa.service;

import com.entreprise.mpa.entity.ExpenseCategory;
import com.entreprise.mpa.repository.ExpenseCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryService {

    private final ExpenseCategoryRepository repo;

    public ExpenseCategoryService(ExpenseCategoryRepository repo) {
        this.repo = repo;
    }

    public List<ExpenseCategory> getAll() {
        return repo.findAllByActiveTrueOrderByNameAsc();
    }

    public ExpenseCategory create(ExpenseCategory category) {
        category.setActive(true);
        return repo.save(category);
    }

    public void delete(Long id) {
        ExpenseCategory category = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense category not found"));

        category.setActive(false);
        repo.save(category);
    }
}