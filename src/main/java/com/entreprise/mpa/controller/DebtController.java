package com.entreprise.mpa.controller;

import com.entreprise.mpa.entity.Debt;
import com.entreprise.mpa.entity.DebtPayment;
import com.entreprise.mpa.service.DebtService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/debts")
@CrossOrigin(origins = "http://localhost:5173")
public class DebtController {

    private final DebtService service;

    public DebtController(DebtService service) {
        this.service = service;
    }

    @GetMapping
    public List<Debt> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Debt create(@RequestBody Debt debt) {
        return service.create(debt);
    }

    @PostMapping("/{id}/payments")
    public Debt addPayment(@PathVariable Long id, @RequestBody DebtPayment payment) {
        return service.addPayment(id, payment);
    }

    @PutMapping("/{id}")
    public Debt update(@PathVariable Long id, @RequestBody Debt debt) {
        return service.update(id, debt);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}