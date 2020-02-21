package com.esvr.retobcp.web;

import com.esvr.retobcp.model.ExchangeRate;
import com.esvr.retobcp.model.api.ExchangeRateQueryParams;
import com.esvr.retobcp.model.api.ExchangeResponse;
import com.esvr.retobcp.model.api.ExchangeUpdate;
import com.esvr.retobcp.service.ExchangeRateService;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/rate/all-exchange")
    @ResponseStatus(HttpStatus.OK)
    public Single<List<ExchangeRate>> getAll(ExchangeRateQueryParams params) {
        return exchangeRateService.getAll();
    }

    @GetMapping("/rate/exchange")
    @ResponseStatus(HttpStatus.OK)
    public Maybe<ExchangeResponse> calculare(ExchangeRateQueryParams params) {
        return exchangeRateService.exchangeCalculate(params);
    }

    @PatchMapping("/rate/exchange/{exchangeId}")
    @ResponseStatus(HttpStatus.OK)
    public Completable updateRate(@PathVariable("exchangeId") Long exchangeId,
                                  @RequestBody ExchangeUpdate body) {
        return exchangeRateService.updateRate(exchangeId, body);
    }
}
