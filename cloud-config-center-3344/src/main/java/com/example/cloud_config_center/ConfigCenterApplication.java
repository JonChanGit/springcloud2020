package com.example.cloud_config_center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Jon Chan
 * @date 2020/7/12 06:07
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConfigCenterApplication.class,args);
  }
}
