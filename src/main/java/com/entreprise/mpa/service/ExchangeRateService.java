package com.entreprise.mpa.service;

import com.entreprise.mpa.entity.ExchangeRate;
import com.entreprise.mpa.repository.ExchangeRateRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExchangeRateService {

    private final ExchangeRateRepository repo;

    public ExchangeRateService(ExchangeRateRepository repo) {
        this.repo = repo;
    }

    public List<ExchangeRate> getAll() {
        return repo.findAllByOrderByDateDescCurrencyAsc();
    }

    public ExchangeRate save(ExchangeRate rate) {
        if (rate.getCurrency() != null) {
            rate.setCurrency(rate.getCurrency().toUpperCase());
        }

        if (rate.getDate() == null) {
            rate.setDate(LocalDate.now());
        }

        if ("EUR".equals(rate.getCurrency())) {
            rate.setRateToEur(BigDecimal.ONE);
        }

        return repo.save(rate);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public BigDecimal convertToEur(BigDecimal amount, String currency, LocalDate date) {
        if (amount == null) {
            return BigDecimal.ZERO;
        }

        if (currency == null || "EUR".equalsIgnoreCase(currency)) {
            return amount;
        }

        LocalDate targetDate = date != null ? date : LocalDate.now();

        ExchangeRate rate = repo
                .findFirstByCurrencyAndDateLessThanEqualOrderByDateDesc(
                        currency.toUpperCase(),
                        targetDate
                )
                .orElseThrow(() -> new RuntimeException("Exchange rate not found for " + currency));

        return amount.multiply(rate.getRateToEur());
    }
}