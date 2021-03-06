package com.example.cloud_consumer_order80.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jon Chan
 * @date 2020/7/8 9:12
 */
@Configuration
public class ApplicationContextConfig {

  @Bean
  public RestTemplate getRestTemplate() {
    return  new RestTemplate();
  }
}
