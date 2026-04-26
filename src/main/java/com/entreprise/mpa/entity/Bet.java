package com.entreprise.mpa.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String platform;

    private BigDecimal stake;

    private BigDecimal win_amount;

    private BigDecimal loss_amount;

    private BigDecimal cashout_amount;

    private BigDecimal deposit;

    private String status; // pending, won, lost, cashout

    private String currency;

    private String description;

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPlatform() {
        return platform;
    }

    public BigDecimal getStake() {
        return stake;
    }

    public BigDecimal getWin_amount() {
        return win_amount;
    }

    public BigDecimal getLoss_amount() {
        return loss_amount;
    }

    public BigDecimal getCashout_amount() {
        return cashout_amount;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public String getStatus() {
        return status;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setStake(BigDecimal stake) {
        this.stake = stake;
    }

    public void setWin_amount(BigDecimal win_amount) {
        this.win_amount = win_amount;
    }

    public void setLoss_amount(BigDecimal loss_amount) {
        this.loss_amount = loss_amount;
    }

    public void setCashout_amount(BigDecimal cashout_amount) {
        this.cashout_amount = cashout_amount;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}