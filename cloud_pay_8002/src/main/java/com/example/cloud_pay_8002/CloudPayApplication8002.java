package com.example.cloud_pay_8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudPayApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(CloudPayApplication8002.class, args);
    }

}
