package com.entreprise.mpa.service;

import com.entreprise.mpa.entity.Debt;
import com.entreprise.mpa.entity.DebtPayment;
import com.entreprise.mpa.repository.DebtPaymentRepository;
import com.entreprise.mpa.repository.DebtRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DebtService {

    private final DebtRepository debtRepository;
    private final DebtPaymentRepository debtPaymentRepository;

    public DebtService(DebtRepository debtRepository, DebtPaymentRepository debtPaymentRepository) {
        this.debtRepository = debtRepository;
        this.debtPaymentRepository = debtPaymentRepository;
    }

    public List<Debt> getAll() {
        return debtRepository.findAllByOrderByDateDesc();
    }

    public Debt create(Debt debt) {
        if (debt.getStatus() == null || debt.getStatus().isBlank()) {
            debt.setStatus("ACTIVE");
        }

        return debtRepository.save(debt);
    }

    @Transactional
    public Debt addPayment(Long debtId, DebtPayment payment) {
        Debt debt = debtRepository.findById(debtId)
                .orElseThrow(() -> new RuntimeException("Debt not found"));

        payment.setDebt(debt);

        debtPaymentRepository.save(payment);

        Debt refreshedDebt = debtRepository.findById(debtId)
                .orElseThrow(() -> new RuntimeException("Debt not found"));

        BigDecimal paid = refreshedDebt.getPayments()
                .stream()
                .map(DebtPayment::getAmount)
                .filter(amount -> amount != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal total = refreshedDebt.getTotalAmount() == null
                ? BigDecimal.ZERO
                : refreshedDebt.getTotalAmount();

        if (paid.compareTo(total) >= 0) {
            refreshedDebt.setStatus("PAID");
        } else if (paid.compareTo(BigDecimal.ZERO) > 0) {
            refreshedDebt.setStatus("PARTIAL");
        } else {
            refreshedDebt.setStatus("ACTIVE");
        }

        return debtRepository.save(refreshedDebt);
    }

    public Debt update(Long id, Debt updated) {
        Debt debt = debtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Debt not found"));

        debt.setPersonName(updated.getPersonName());
        debt.setTotalAmount(updated.getTotalAmount());
        debt.setCurrency(updated.getCurrency());
        debt.setDate(updated.getDate());
        debt.setDescription(updated.getDescription());
        debt.setStatus(updated.getStatus());

        return debtRepository.save(debt);
    }

    public void delete(Long id) {
        debtRepository.deleteById(id);
    }
}