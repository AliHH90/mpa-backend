package com.entreprise.mpa.controller;

import com.entreprise.mpa.entity.ExchangeRate;
import com.entreprise.mpa.service.ExchangeRateService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exchange-rates")
@CrossOrigin(origins = "http://localhost:5173")
public class ExchangeRateController {

    private final ExchangeRateService service;

    public ExchangeRateController(ExchangeRateService service) {
        this.service = service;
    }

    @GetMapping
    public List<ExchangeRate> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ExchangeRate save(@RequestBody ExchangeRate rate) {
        return service.save(rate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/convert")
    public Map<String, Object> convert(
            @RequestParam BigDecimal amount,
            @RequestParam String currency,
            @RequestParam(required = false) LocalDate date
    ) {
        BigDecimal eurAmount = service.convertToEur(amount, currency, date);

        return Map.of(
                "amount", amount,
                "currency", currency,
                "date", date != null ? date : LocalDate.now(),
                "eurAmount", eurAmount
        );
    }
}