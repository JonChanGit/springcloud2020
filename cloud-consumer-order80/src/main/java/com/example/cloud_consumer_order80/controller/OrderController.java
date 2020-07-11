package com.example.cloud_consumer_order80.controller;

import com.example.cloud_api_commons.entity.Payment;
import com.example.cloud_consumer_order80.rpc.PaymentRpcService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Jon Chan
 * @date 2020/7/8 9:14
 */
@RestController
@Slf4j
@AllArgsConstructor
public class OrderController {

  private PaymentRpcService rpcService;

  @GetMapping(value = "/ok/{id}")
  ResponseEntity<String> ok(@PathVariable("id") Long id) {
    return rpcService.ok(id);
  }

  @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutFallbackMethod", commandProperties = {
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
  })
  @GetMapping(value = "/timeout/{id}")
  ResponseEntity<String> timeOut(@PathVariable("id") Long id) {
    return rpcService.timeOut(id);
  }

  /**
   * 签名（除方法名）要和切入方法完全一致
   * @param id
   * @return
   */
  public ResponseEntity<String> paymentInfo_TimeoutFallbackMethod(@PathVariable("id") Long id) {
    return ResponseEntity.ok("/(ToT)/我是消费者80，调用8001支付系统繁忙，请10秒钟后重新尝试、\t");
  }

}
