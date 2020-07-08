package com.example.cloud_pay_8006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
public class CloudPayApplication8006 {

    public static void main(String[] args) {
        SpringApplication.run(CloudPayApplication8006.class, args);
    }

}
