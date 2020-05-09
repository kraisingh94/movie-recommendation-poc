package com.infogain.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.infogain.controller", "com.infogain.service", "com.infogain.fallbacks"})
@EntityScan(basePackages = {"com.infogain.entity"})
@EnableFeignClients(basePackages = {"com.infogain.clients"})
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ClientConfig {
    
}
