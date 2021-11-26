package com.in28minutes.microservices.spingcloudapigateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Slf4j
@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        log.info("------------------------------------------------------------------------------------");
        Function<PredicateSpec, Buildable<Route>> fn = p-> {
            log.info("log route url {}",p.toString());
            return p.path("/currency-exchange-service/**")
                    .uri("lb://CURRENCY-EXCHANGE-SERVICE");
        };
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
//                .route(p -> p.path("/currency-exchange-service/**")
//                        .uri("lb://CURRENCY-EXCHANGE-SERVICE"))
                .route(fn)
                .route(p -> p.path("/currency-conversion-service/**")
                        .uri("lb://currency-conversion-service"))
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion-feign"))
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion-feign/${segment}"))
                        .uri("lb://currency-conversion"))
                .build();
    }

}