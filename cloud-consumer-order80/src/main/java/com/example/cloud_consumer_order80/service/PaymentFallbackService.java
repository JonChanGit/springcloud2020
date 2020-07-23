package com.example.cloud_consumer_order80.service;

import com.example.cloud_api_commons.entity.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Jon Chan
 * @date 2020/7/23 11:29
 */
@Component
public class PaymentFallbackService implements PaymentService {
  public ResponseEntity create(@RequestBody Payment payment) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("服务降级返回，---PaymentFallbackService");
  }

  public ResponseEntity getPaymentById(@PathVariable("id") Long id) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("服务降级返回，---PaymentFallbackService");
  }
}
