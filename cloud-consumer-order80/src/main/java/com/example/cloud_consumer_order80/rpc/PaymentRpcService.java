package com.example.cloud_consumer_order80.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Jon Chan
 * @date 2020/7/11 14:11
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE", configuration = {})
public interface PaymentRpcService {

  @GetMapping(value = "/ok/{id}")
  ResponseEntity<String> ok(@PathVariable("id") Long id);


  @GetMapping(value = "/timeout/{id}")
  ResponseEntity<String> timeOut(@PathVariable("id") Long id);
}
