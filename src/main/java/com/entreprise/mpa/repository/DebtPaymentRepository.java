package com.entreprise.mpa.repository;

import com.entreprise.mpa.entity.DebtPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtPaymentRepository extends JpaRepository<DebtPayment, Long> {
}