package com.example.cloud_consumer_order80.controller;

import com.example.cloud_api_commons.entity.Payment;
import com.example.cloud_consumer_order80.rpc.PaymentRpcService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jon Chan
 * @date 2020/7/8 9:14
 */
@RestController
@Slf4j
@AllArgsConstructor
public class OrderController {

  private PaymentRpcService rpcService;


  @PostMapping(value = "/consumer/payment/create")
  public ResponseEntity<Void> create(@RequestBody Payment payment) {
    return rpcService.create(payment);
  }

  @GetMapping("/consumer/payment/get/{id}")
  public ResponseEntity<Payment> getPayment(@PathVariable("id") Long id) {
    return rpcService.getPaymentById(id);
  }


  /**
   * 超时测试
   * @return
   */
  @GetMapping(value = "timeout")
  public ResponseEntity<String> timeout() {
    return rpcService.timeout();
  }


  @GetMapping(value="/consumer/payment/zipkin")
  public ResponseEntity<String> paymentZipkin() {
    return rpcService.paymentZipkin();
  }

}
