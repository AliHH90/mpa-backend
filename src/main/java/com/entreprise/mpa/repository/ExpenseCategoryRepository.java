package com.entreprise.mpa.repository;

import com.entreprise.mpa.entity.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long> {

    List<ExpenseCategory> findAllByActiveTrueOrderByNameAsc();
}