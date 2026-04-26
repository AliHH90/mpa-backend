package com.entreprise.mpa.repository;

import com.entreprise.mpa.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    List<Income> findAllByOrderByDateDesc();
}