package com.entreprise.mpa.service;

import com.entreprise.mpa.entity.IncomeSource;
import com.entreprise.mpa.repository.IncomeSourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeSourceService {

    private final IncomeSourceRepository repo;

    public IncomeSourceService(IncomeSourceRepository repo) {
        this.repo = repo;
    }

    public List<IncomeSource> getAll() {
        return repo.findAllByActiveTrueOrderByNameAsc();
    }

    public IncomeSource create(IncomeSource source) {
        source.setActive(true);
        return repo.save(source);
    }

    public void delete(Long id) {
        IncomeSource source = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Income source not found"));

        source.setActive(false);
        repo.save(source);
    }
}