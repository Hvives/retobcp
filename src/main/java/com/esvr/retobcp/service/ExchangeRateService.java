package com.esvr.retobcp.service;

import com.esvr.retobcp.model.ExchangeRate;
import com.esvr.retobcp.model.api.ExchangeRateQueryParams;
import com.esvr.retobcp.model.api.ExchangeResponse;
import com.esvr.retobcp.model.api.ExchangeUpdate;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

import java.util.List;

public interface ExchangeRateService {

    public Maybe<ExchangeRate> findByFromCoinAndToCoin(String fromCoin, String toCoin);
    public Maybe<ExchangeResponse> exchangeCalculate(ExchangeRateQueryParams params);
    public Completable updateRate(Long exchangeId, ExchangeUpdate dataUpdate);
    public Single<List<ExchangeRate>> getAll();
}
