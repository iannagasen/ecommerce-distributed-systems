package com.agasen.ecommercegateway;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.resolver.DefaultAddressResolverGroup;
import lombok.extern.slf4j.Slf4j;
import reactor.netty.http.client.HttpClient;

@Configuration
@Slf4j
public class GatewayConfiguration {

    // We will use app.yaml instead

    // @Bean
    // public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
    // return builder.routes()
    // .route(predicate -> predicate
    // .path("/get") // if path is localhost:8765/get
    // .filters(f -> f
    // .addRequestHeader("MyHeader", "MyURI")
    // .addRequestHeader("Param", "MyValue"))
    // .uri("http://httpbin.org:80") // then redirect/route to this
    // )
    // .route("product-service", predicate -> predicate
    // .path("/product-service")
    // .uri("lb://PRODUCT-SERVICE/"))
    // .build();
    // }

    @Bean
    public GlobalFilter setGlobalFilter() {
        return (exchange, filterChain) -> {
            log.info("Path of the request received -> {}", exchange.getRequest().getPath());
            return filterChain.filter(exchange);
        };
    }

    @Bean
    public HttpClient httpClient() {
        return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
    }
}
