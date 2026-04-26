package com.entreprise.mpa.controller;

import com.entreprise.mpa.entity.MonthlyExpenseBudget;
import com.entreprise.mpa.service.MonthlyExpenseBudgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monthly-expense-budgets")
@CrossOrigin(origins = "http://localhost:5173")
public class MonthlyExpenseBudgetController {

    private final MonthlyExpenseBudgetService service;

    public MonthlyExpenseBudgetController(MonthlyExpenseBudgetService service) {
        this.service = service;
    }

    @GetMapping
    public List<MonthlyExpenseBudget> getAll() {
        return service.getAll();
    }

    @GetMapping("/{month}")
    public MonthlyExpenseBudget getByMonth(@PathVariable String month) {
        return service.getByMonth(month);
    }

    @PostMapping
    public MonthlyExpenseBudget saveOrUpdate(@RequestBody MonthlyExpenseBudget budget) {
        return service.saveOrUpdate(budget);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}