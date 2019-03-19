package com.learning.linnyk.cloud.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server") // 1.
@RibbonClient(name = "currency-exchange-service")      // 2.
public interface CurrencyExchangeServiceProxy {

    // 1. Uses in order not to call microservice via api-gateway
    // 2. Ribbon use Discovery Server to find needed microservice and balance requests

    /*@GetMapping("/currency-exchange/from/{from}/to/{to}") */                      // 1.
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") // 2.
    CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
