package com.entreprise.mpa.repository;

import com.entreprise.mpa.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DebtRepository extends JpaRepository<Debt, Long> {
    List<Debt> findAllByOrderByDateDesc();
}