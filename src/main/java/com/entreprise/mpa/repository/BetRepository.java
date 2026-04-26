package com.entreprise.mpa.repository;

import com.entreprise.mpa.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {

    List<Bet> findAllByOrderByDateDesc();
}