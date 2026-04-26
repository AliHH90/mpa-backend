package com.entreprise.mpa.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Debt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String personName;
    private BigDecimal totalAmount;
    private String currency;
    private LocalDate date;
    private String description;
    private String status; // ACTIVE, PARTIAL, PAID

    @OneToMany(mappedBy = "debt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DebtPayment> payments = new ArrayList<>();

    public Long getId() { return id; }
    public String getPersonName() { return personName; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public String getCurrency() { return currency; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public List<DebtPayment> getPayments() { return payments; }

    public void setId(Long id) { this.id = id; }
    public void setPersonName(String personName) { this.personName = personName; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
    public void setPayments(List<DebtPayment> payments) { this.payments = payments; }
    
    
    @Transient
    public BigDecimal getPaidAmount() {
        if (payments == null) {
            return BigDecimal.ZERO;
        }

        return payments.stream()
                .map(DebtPayment::getAmount)
                .filter(amount -> amount != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Transient
    public BigDecimal getRemainingAmount() {
        if (totalAmount == null) {
            return BigDecimal.ZERO;
        }

        return totalAmount.subtract(getPaidAmount());
    }
    
}