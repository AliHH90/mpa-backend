package com.entreprise.mpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String source; // منبع درآمد مثل Salary, CAF, Uber

    @NotNull
    private BigDecimal amount; // مقدار درآمد

    @NotBlank
    private String currency; // EUR, USD, AFN, IRR

    @NotNull
    private LocalDate date; // تاریخ درآمد

    private String description; // توضیحات اختیاری

    public Income() {
    }

    public Income(Long id, String source, BigDecimal amount, String currency, LocalDate date, String description) {
        this.id = id;
        this.source = source;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
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

    public void setSource(String source) {
        this.source = source;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}