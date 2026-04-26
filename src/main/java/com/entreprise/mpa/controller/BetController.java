package com.entreprise.mpa.controller;

import com.entreprise.mpa.entity.Bet;
import com.entreprise.mpa.service.BetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bets")
@CrossOrigin(origins = "http://localhost:5173")
public class BetController {

    private final BetService service;

    public BetController(BetService service) {
        this.service = service;
    }

    @GetMapping
    public List<Bet> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Bet create(@RequestBody Bet bet) {
        return service.create(bet);
    }

    @PutMapping("/{id}")
    public Bet update(@PathVariable Long id, @RequestBody Bet bet) {
        return service.update(id, bet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}