package com.entreprise.mpa.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class MonthlyExpenseBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // مثال: 2026-04
    @Column(nullable = false, unique = true)
    private String month;

    @Column(nullable = false)
    private BigDecimal amount;

    private String currency = "EUR";

    public Long getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}