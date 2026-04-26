package com.entreprise.mpa.repository;

import com.entreprise.mpa.entity.MonthlyExpenseBudget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonthlyExpenseBudgetRepository extends JpaRepository<MonthlyExpenseBudget, Long> {

    Optional<MonthlyExpenseBudget> findByMonth(String month);
}