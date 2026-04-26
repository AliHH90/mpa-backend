package com.entreprise.mpa.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private String currency;

    private String category; // FAMILY, WIFE_FAMILY, FRIENDS, CHARITY

    private String receiver;

    private LocalDate date;

    private String description;

    // ===== GETTERS =====

    public Long getId() { return id; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getCategory() { return category; }
    public String getReceiver() { return receiver; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }

    // ===== SETTERS =====

    public void setId(Long id) { this.id = id; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setCategory(String category) { this.category = category; }
    public void setReceiver(String receiver) { this.receiver = receiver; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setDescription(String description) { this.description = description; }
}