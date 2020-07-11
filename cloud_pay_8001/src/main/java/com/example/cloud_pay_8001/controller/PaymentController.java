package com.example.cloud_pay_8001.controller;

import com.example.cloud_api_commons.entity.Payment;
import com.example.cloud_pay_8001.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jon Chan
 * @date 2020/7/8 8:44
 */
@AllArgsConstructor
@RestController
@Slf4j
public class PaymentController {
  private PaymentService paymentService;


  @GetMapping(value = "/ok/{id}")
  public ResponseEntity<String> ok(@PathVariable("id") Long id) {
    String payment = paymentService.paymentInfo(id);
    log.info("****查询结果:" + payment);
    return ResponseEntity.ok(payment);
  }

  @GetMapping(value = "/timeout/{id}")
  public ResponseEntity<String> timeOut(@PathVariable("id") Long id) {
    String payment = paymentService.paymentInfo_Timeout(id);
    log.info("****查询结果:" + payment);
    return ResponseEntity.ok(payment);
  }

}
