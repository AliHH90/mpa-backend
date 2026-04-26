package com.entreprise.mpa.controller;

import com.entreprise.mpa.entity.IncomeSource;
import com.entreprise.mpa.service.IncomeSourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income-sources")
@CrossOrigin(origins = "http://localhost:5173")
public class IncomeSourceController {

    private final IncomeSourceService service;

    public IncomeSourceController(IncomeSourceService service) {
        this.service = service;
    }

    @GetMapping
    public List<IncomeSource> getAll() {
        return service.getAll();
    }

    @PostMapping
    public IncomeSource create(@RequestBody IncomeSource source) {
        return service.create(source);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}