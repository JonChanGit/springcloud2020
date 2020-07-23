package com.example.cloud_pay_8001.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.cloud_api_commons.entity.Payment;
import com.example.cloud_pay_8001.handler.CustomerBlockHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义限流测试
 * @author Jon Chan
 * @date 2020/7/22 14:49
 */
@RestController
public class RateLimitController {

  @GetMapping("/byResource")
  @SentinelResource(value = "byResource",blockHandler = "handleException")
  public ResponseEntity<Payment> byResource() {
    return  ResponseEntity.ok(new Payment(2020L,"serial001"));
  }

  public ResponseEntity<Payment> handleException(BlockException exception) {
    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  @GetMapping("/rateLimit/byUrl")
  @SentinelResource(value = "byUrl")
  public ResponseEntity<Payment> byUrl() {
    return  ResponseEntity.ok(new Payment(2020L,"serial002"));
  }


  /**
   *
   * CustomerBlockHandler
   *
   */
  @GetMapping("/rateLimit/customerBlockHandler")
  @SentinelResource(value = "customerBlockHandler",
    blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
  public ResponseEntity<Payment> customerBlockHandler() {
    return  ResponseEntity.ok(new Payment(2020L,"serial003"));
  }

}
