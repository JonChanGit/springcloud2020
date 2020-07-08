package com.example.cloud_eureka_server_7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jon Chan
 * @date 2020/7/8 10:15
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {

  public static void main(String[] args) {
    SpringApplication.run(EurekaMain7002.class,args);
  }
}
