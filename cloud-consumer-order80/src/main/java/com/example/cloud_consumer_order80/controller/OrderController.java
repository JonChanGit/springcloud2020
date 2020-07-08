package com.example.cloud_consumer_order80.controller;

import com.example.cloud_api_commons.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Jon Chan
 * @date 2020/7/8 9:14
 */
@RestController
@Slf4j
@AllArgsConstructor
public class OrderController {
  // public static final String PAYMENT_URL = "http://localhost:8001";
  public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
  private RestTemplate restTemplate;

  private DiscoveryClient discoveryClient;


  @PostMapping(value = "/consumer/payment/create")
  public ResponseEntity<Void> create(@RequestBody Payment payment) {
    return restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, Void.class);
  }

  @GetMapping("/consumer/payment/get/{id}")
  public ResponseEntity<Payment> getPayment(@PathVariable("id") Long id) {
    return restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, Payment.class);
  }

  /**
   * 使用代码
   * @return
   */
  @GetMapping(value = "/payment/discovery")
  public Object discovery() {
    // 好像不加@EnableDiscoveryClient也可以
   List<String> services = discoveryClient.getServices();

    for (String serviceId : services) {
      log.info("*****element:" + serviceId);
      List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
      for (ServiceInstance instance : instances) {
        log.info(instance.getServiceId() + "\t" + instance.getHost() +
                "\t" + instance.getPort() + "\t" + instance.getUri());
        log.info("{}",instance.getMetadata());
      }
    }

    return this.discoveryClient;
  }
}
