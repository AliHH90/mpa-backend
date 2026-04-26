package com.entreprise.mpa.controller;

import com.entreprise.mpa.entity.ExpenseCategory;
import com.entreprise.mpa.service.ExpenseCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense-categories")
@CrossOrigin(origins = "http://localhost:5173")
public class ExpenseCategoryController {

    private final ExpenseCategoryService service;

    public ExpenseCategoryController(ExpenseCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<ExpenseCategory> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ExpenseCategory create(@RequestBody ExpenseCategory category) {
        return service.create(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}