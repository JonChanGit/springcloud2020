package com.example.cloud_consumer_order80.controller;

import com.example.cloud_api_commons.entity.Payment;
import com.example.cloud_consumer_order80.config.ServiceNameProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jon Chan
 * @date 2020/7/8 9:14
 */
@RestController
@Slf4j
@AllArgsConstructor
public class OrderController {
  private RestTemplate restTemplate;
  private ServiceNameProperties serviceProperties;

  @PostMapping(value = "/consumer/payment/create")
  public ResponseEntity<Void> create(@RequestBody Payment payment) {
    return restTemplate.postForEntity(serviceProperties.getProvider() + "/payment/create", payment, Void.class);
  }

  @GetMapping("/consumer/payment/get/{id}")
  public ResponseEntity<Payment> getPayment(@PathVariable("id") Long id) {
    return restTemplate.getForEntity(serviceProperties.getProvider() + "/payment/get/" + id, Payment.class);
  }
}
