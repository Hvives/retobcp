package com.esvr.retobcp.repository;

import com.esvr.retobcp.model.ExchangeRate;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {

    ExchangeRate findByFromCoinAndToCoin(String fromCoin, String toCoin);
}
