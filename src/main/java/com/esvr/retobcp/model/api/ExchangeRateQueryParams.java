package com.esvr.retobcp.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Generated("com.googlecode.jsonschema2pojo")
public class ExchangeRateQueryParams {

    @NotNull(message = "Debe tener algún valor")
    @NotEmpty(message = "No puede estar vacío")
    private String fromCoin;
    private String toCoin;
    private BigDecimal amount;
}
