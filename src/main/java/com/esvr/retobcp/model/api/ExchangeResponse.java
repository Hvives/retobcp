package com.esvr.retobcp.model.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ExchangeResponse {

    private Long id;
    private String fromCoin;
    private String toCoin;
    private BigDecimal amount;
    private BigDecimal exchangeAmount;
    private BigDecimal rate;
}
