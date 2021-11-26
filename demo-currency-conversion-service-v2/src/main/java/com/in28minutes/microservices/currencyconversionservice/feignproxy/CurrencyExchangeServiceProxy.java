package com.in28minutes.microservices.currencyconversionservice.feignproxy;

import com.in28minutes.microservices.currencyconversionservice.CurrencyConversionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service")
//@FeignClient(name="netflix-zuul-api-gateway-server") netflix zuul is not supported now
//@RibbonClient(name="currency-exchange-service")
// In earlier Version Ribbon Used for Client Side Load Balancing now Shifted to Spring Cloud Load Balancer
//Which Using Feign. You need to Use Feign and Eureka to use the load balancing automatically
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	//@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue
		(@PathVariable("from") String from, @PathVariable("to") String to);
}
