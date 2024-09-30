package com.example.gateway_service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator router(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("employeeService", r -> r.path("/api/employees/**").uri("lb://employee-service"))
                .route("buildingService", r -> r.path("/api/buildings/**").uri("lb://building-service"))
                .build();
    }

}
