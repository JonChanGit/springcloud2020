package com.example.cloud_pay_8001.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

  /**
   * 超时访问或运行时异常，演示降级
   * @param id
   * @return
   */
  @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
  })
  public String paymentInfo_Timeout(Long id){
    // System.out.printf(1/0 + "");
    try {
      TimeUnit.SECONDS.sleep(7);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "Thread Name : " + Thread.currentThread().getName() + " \t id: "+ id + "\t paymentInfo_Timeout";
  }

  public String paymentInfo_TimeoutHandler(Long id) {
    return "/(ToT)/调用接口超时或异常、\t" + "\t当前线程池名字" + Thread.currentThread().getName();
  }
}
