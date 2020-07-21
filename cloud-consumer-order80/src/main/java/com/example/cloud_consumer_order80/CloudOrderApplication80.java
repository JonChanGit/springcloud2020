package com.example.cloud_consumer_order80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudOrderApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(CloudOrderApplication80.class, args);
    }

}
