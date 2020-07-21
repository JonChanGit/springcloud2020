package com.example.cloud_consumer_order80.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jon Chan
 * @date 2020/7/21 16:10
 */
@Component
@ConfigurationProperties(prefix = "services")
@Data
public class ServiceNameProperties {
  private String provider;
}
