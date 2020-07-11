package com.example.cloud_pay_8001.service;

import cn.hutool.core.util.IdUtil;
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


  // 服务熔断
  @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),              //是否开启断路器
    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
  })
  public String paymentCircuitBreaker(Integer id) {
    if(id < 0){
      throw  new RuntimeException("****id 不能为负数");
    }
    String serialNumber = IdUtil.simpleUUID();

    return  Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
  }

  public String paymentCircuitBreaker_fallback(Integer id){
    return "id 不能为负数,请稍后再试， o(╥﹏╥)o id: " + id;
  }

}
