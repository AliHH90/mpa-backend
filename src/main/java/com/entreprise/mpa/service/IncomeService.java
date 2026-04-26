package com.entreprise.mpa.service;

import com.entreprise.mpa.entity.Income;
import com.entreprise.mpa.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAllByOrderByDateDesc();
    }

    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    public Income updateIncome(Long id, Income updatedIncome) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income not found"));

        income.setSource(updatedIncome.getSource());
        income.setAmount(updatedIncome.getAmount());
        income.setCurrency(updatedIncome.getCurrency());
        income.setDate(updatedIncome.getDate());
        income.setDescription(updatedIncome.getDescription());

        return incomeRepository.save(income);
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}