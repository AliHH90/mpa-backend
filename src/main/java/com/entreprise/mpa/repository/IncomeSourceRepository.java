package com.entreprise.mpa.repository;

import com.entreprise.mpa.entity.IncomeSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeSourceRepository extends JpaRepository<IncomeSource, Long> {

    List<IncomeSource> findAllByActiveTrueOrderByNameAsc();
}