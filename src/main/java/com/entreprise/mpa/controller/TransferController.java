package com.entreprise.mpa.controller;

import com.entreprise.mpa.entity.Transfer;
import com.entreprise.mpa.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
@CrossOrigin(origins = "http://localhost:5173")
public class TransferController {

    private final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transfer> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Transfer create(@RequestBody Transfer t) {
        return service.create(t);
    }

    @PutMapping("/{id}")
    public Transfer update(@PathVariable Long id, @RequestBody Transfer t) {
        return service.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}