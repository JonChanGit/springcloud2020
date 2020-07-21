package com.example.cloud_pay_8001.controller;

import com.example.cloud_api_commons.entity.Payment;
import com.example.cloud_pay_8001.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jon Chan
 * @date 2020/7/8 8:44
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class PaymentController {
  private final PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  @PostMapping(value = "/payment/create")
  public ResponseEntity<Void> create(@RequestBody Payment payment) {
    paymentService.create(payment);
    log.info("****node {}  插入结果: SUCCESS", serverPort);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/payment/get/{id}")
  public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("****node {}  查询结果: {} ", serverPort, payment);

    return ResponseEntity.ok(payment);
  }

}
