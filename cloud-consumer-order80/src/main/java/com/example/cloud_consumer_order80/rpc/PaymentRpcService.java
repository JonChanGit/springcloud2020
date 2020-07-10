package com.example.cloud_consumer_order80.rpc;

import com.example.cloud_api_commons.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jon Chan
 * @date 2020/7/8 8:44
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentRpcService {

  @PostMapping(value = "/payment/create")
  ResponseEntity<Void> create(@RequestBody Payment payment) ;

  @GetMapping(value = "/payment/get/{id}")
  ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id);
}
