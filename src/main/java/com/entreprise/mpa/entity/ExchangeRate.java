package com.entreprise.mpa.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
    name = "exchange_rates",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"currency", "date"})
    }
)
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // AFN, USD, IRR, EUR
    private String currency;

    // مثلا: 1 USD = 0.93 EUR
    @Column(precision = 19, scale = 8)
    private BigDecimal rateToEur;

    private LocalDate date;

    private String description;

    public Long getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getRateToEur() {
        return rateToEur;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setRateToEur(BigDecimal rateToEur) {
        this.rateToEur = rateToEur;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}