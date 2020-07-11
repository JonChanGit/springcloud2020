package com.example.cloud_pay_8001.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Jon Chan
 * @date 2020/7/8 8:43
 */
@Service
@AllArgsConstructor
public class PaymentService {
  public String paymentInfo(Long id){
    return "Thread Name : " + Thread.currentThread().getName() + " \t id: "+ id;
  }
  public String paymentInfo_Timeout(Long id){
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "Thread Name : " + Thread.currentThread().getName() + " \t id: "+ id;
  }
}
