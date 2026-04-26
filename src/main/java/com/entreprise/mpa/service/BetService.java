package com.entreprise.mpa.service;

import com.entreprise.mpa.entity.Bet;
import com.entreprise.mpa.repository.BetRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BetService {

    private final BetRepository repo;

    public BetService(BetRepository repo) {
        this.repo = repo;
    }

    public List<Bet> getAll() {
        return repo.findAllByOrderByDateDesc();
    }

    public Bet create(Bet bet) {
        setDefaultNumbers(bet);

        if (bet.getStatus() == null || bet.getStatus().isBlank()) {
            bet.setStatus("pending");
        }

        return repo.save(bet);
    }

    public Bet update(Long id, Bet updated) {
        Bet bet = repo.findById(id).orElseThrow();

        bet.setDate(updated.getDate());
        bet.setPlatform(updated.getPlatform());
        bet.setStake(valueOrZero(updated.getStake()));
        bet.setWin_amount(valueOrZero(updated.getWin_amount()));
        bet.setLoss_amount(valueOrZero(updated.getLoss_amount()));
        bet.setCashout_amount(valueOrZero(updated.getCashout_amount()));
        bet.setDeposit(valueOrZero(updated.getDeposit()));
        bet.setStatus(updated.getStatus());
        bet.setCurrency(updated.getCurrency());
        bet.setDescription(updated.getDescription());

        return repo.save(bet);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private void setDefaultNumbers(Bet bet) {
        bet.setStake(valueOrZero(bet.getStake()));
        bet.setWin_amount(valueOrZero(bet.getWin_amount()));
        bet.setLoss_amount(valueOrZero(bet.getLoss_amount()));
        bet.setCashout_amount(valueOrZero(bet.getCashout_amount()));
        bet.setDeposit(valueOrZero(bet.getDeposit()));
    }

    private BigDecimal valueOrZero(BigDecimal value) {
        return value == null ? BigDecimal.ZERO : value;
    }
}