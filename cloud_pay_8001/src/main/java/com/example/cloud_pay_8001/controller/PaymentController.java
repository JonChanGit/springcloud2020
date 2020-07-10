package com.example.cloud_pay_8001.controller;

import com.example.cloud_api_commons.entity.Payment;
import com.example.cloud_pay_8001.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author Jon Chan
 * @date 2020/7/8 8:44
 */
@AllArgsConstructor
@RestController
@Slf4j
public class PaymentController {
  private PaymentService paymentService;

  @PostMapping(value = "/payment/create")
  public ResponseEntity<Void> create(@RequestBody Payment payment) {
    paymentService.create(payment);
    log.info("****插入结果: SUCCESS");
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/payment/get/{id}")
  public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("****查询结果:" + payment);

    return ResponseEntity.ok(payment);
  }

  /**
   * 超时测试接口
   * @return
   * @throws InterruptedException
   */
  @GetMapping(value = "timeout")
  public ResponseEntity<String> timeout() throws InterruptedException {

    TimeUnit.SECONDS.sleep(6);
    return ResponseEntity.ok("OK");
  }
}
