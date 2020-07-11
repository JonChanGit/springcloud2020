package com.example.cloud_pay_8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
// 启用断路器
@EnableCircuitBreaker
public class CloudPayApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudPayApplication8001.class, args);
    }

}
