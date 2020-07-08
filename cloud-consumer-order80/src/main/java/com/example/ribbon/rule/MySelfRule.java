package com.example.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jon Chan
 * @date 2020/7/8 20:37
 */
@Configuration
public class MySelfRule {
  /**
   * 指定使用的负载均衡方案
   * @return
   */
  @Bean
  public IRule myRule(){
    return new RandomRule();
  }
}
