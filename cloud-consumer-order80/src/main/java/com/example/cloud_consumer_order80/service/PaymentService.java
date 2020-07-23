package com.example.cloud_consumer_order80.service;

import com.example.cloud_api_commons.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Jon Chan
 * @date 2020/7/23 11:27
 */
@FeignClient(value = "cloud-payment-service", fallback = PaymentFallbackService.class)
public interface PaymentService {

  @PostMapping(value = "/payment/create")
  ResponseEntity<Void> create(@RequestBody Payment payment);

  @GetMapping(value = "/payment/get/{id}")
  ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id);
}
