package com.esvr.retobcp.service.impl;

import com.esvr.retobcp.exception.RetoBcpException;
import com.esvr.retobcp.exception.RetoBcpExceptionBuilder;
import com.esvr.retobcp.model.ExchangeRate;
import com.esvr.retobcp.model.api.ExchangeRateQueryParams;
import com.esvr.retobcp.model.api.ExchangeResponse;
import com.esvr.retobcp.model.api.ExchangeUpdate;
import com.esvr.retobcp.repository.ExchangeRateRepository;
import com.esvr.retobcp.service.ExchangeRateService;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ExchangeRateImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public Single<List<ExchangeRate>> getAll() {
        return Single.just((List<ExchangeRate>)exchangeRateRepository.findAll());
    }

    @Override
    public Maybe<ExchangeResponse> exchangeCalculate(ExchangeRateQueryParams params) {
        return this.findByFromCoinAndToCoin(params.getFromCoin(), params.getToCoin())
                .map(exchange -> ExchangeResponse.builder()
                        .id(exchange.getId())
                        .fromCoin(exchange.getFromCoin())
                        .toCoin(exchange.getToCoin())
                        .amount(params.getAmount())
                        .exchangeAmount(params.getAmount().multiply(exchange.getRate()))
                        .rate(exchange.getRate()).build())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Maybe<ExchangeRate> findByFromCoinAndToCoin(String fromCoin, String toCoin) {
        Optional<ExchangeRate> optionalExchange = Optional.ofNullable(exchangeRateRepository.findByFromCoinAndToCoin(fromCoin, toCoin));
        return Maybe.just(optionalExchange)
                .flatMap(optional -> {
                    if(optional.isPresent()) {
                        return Maybe.just(optional.get());
                    } else {
                        return Maybe.empty();
                    }
                });
    }

    @Override
    public Completable updateRate(Long exchangeId, ExchangeUpdate dataUpdate) {
        ExchangeRate exchangeRate = exchangeRateRepository.findById(exchangeId).orElse(null);

        if(null == exchangeRate) {
            return RetoBcpException.builder().systemCode("404").description("Unexpected").buildAsCompletable();
        }

        exchangeRate.setRate(dataUpdate.getRate());

        return Single.just(exchangeRateRepository.save(exchangeRate)).ignoreElement()
                .onErrorResumeNext(ex -> RetoBcpExceptionBuilder.builder().systemCode("500")
                .description(ex.getMessage()).buildAsSingle().ignoreElement());
    }
}
