package com.entreprise.mpa.service;

import com.entreprise.mpa.entity.Expense;
import com.entreprise.mpa.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repo;

    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }

    public List<Expense> getAll() {
        return repo.findAllByOrderByDateDesc();
    }

    public Expense create(Expense e) {
        return repo.save(e);
    }

    public Expense update(Long id, Expense e) {
        Expense ex = repo.findById(id).orElseThrow();
        ex.setCategory(e.getCategory());
        ex.setAmount(e.getAmount());
        ex.setCurrency(e.getCurrency());
        ex.setDate(e.getDate());
        ex.setDescription(e.getDescription());
        return repo.save(ex);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}