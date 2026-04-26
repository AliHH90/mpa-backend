package com.entreprise.mpa.service;

import com.entreprise.mpa.entity.Transfer;
import com.entreprise.mpa.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    private final TransferRepository repo;

    public TransferService(TransferRepository repo) {
        this.repo = repo;
    }

    public List<Transfer> getAll() {
        return repo.findAllByOrderByDateDesc();
    }

    public Transfer create(Transfer t) {
        return repo.save(t);
    }

    public Transfer update(Long id, Transfer t) {
        Transfer tr = repo.findById(id).orElseThrow();

        tr.setAmount(t.getAmount());
        tr.setCurrency(t.getCurrency());
        tr.setCategory(t.getCategory());
        tr.setReceiver(t.getReceiver());
        tr.setDate(t.getDate());
        tr.setDescription(t.getDescription());

        return repo.save(tr);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}