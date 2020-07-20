package com.example.cloud_config_clinet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jon Chan
 * @date 2020/7/12 06:07
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication3366 {
  public static void main(String[] args) {
    SpringApplication.run(ConfigClientApplication3366.class,args);
  }
}
