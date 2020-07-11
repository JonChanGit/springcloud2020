package com.example.cloud_consumer_order80.rpc.fallback;

import com.example.cloud_consumer_order80.rpc.PaymentRpcService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Jon Chan
 * @date 2020/7/11 21:46
 */
@Component
public class PaymentRpcServiceFallback implements PaymentRpcService {
  public ResponseEntity<String> ok(@PathVariable("id") Long id) {
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("----PaymentFallbackService fall back paymentInfo_OK,o(╥﹏╥)o");
  }

  public ResponseEntity<String> timeOut(@PathVariable("id") Long id) {
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("----PaymentFallbackService fall back timeOut,o(╥﹏╥)o");
  }
}
