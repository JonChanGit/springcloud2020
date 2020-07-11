package com.example.cloud_consumer_order80.controller;

import com.example.cloud_api_commons.entity.Payment;
import com.example.cloud_consumer_order80.rpc.PaymentRpcService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
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

  @GetMapping(value = "/timeout/{id}")
  ResponseEntity<String> timeOut(@PathVariable("id") Long id) {
    return rpcService.timeOut(id);
  }

  @GetMapping(value = "/timeout/default/{id}")
  ResponseEntity<String> defaultTimeOut(@PathVariable("id") Long id) {
    return rpcService.timeOut(id);
  }

}
