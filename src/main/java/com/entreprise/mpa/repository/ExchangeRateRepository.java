package com.entreprise.mpa.repository;

import com.entreprise.mpa.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    List<ExchangeRate> findAllByOrderByDateDescCurrencyAsc();

    Optional<ExchangeRate> findByCurrencyAndDate(String currency, LocalDate date);

    Optional<ExchangeRate> findFirstByCurrencyAndDateLessThanEqualOrderByDateDesc(
            String currency,
            LocalDate date
    );
}