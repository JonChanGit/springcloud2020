package com.example.cloud_consumer_order80.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.cloud_api_commons.entity.Payment;
import com.example.cloud_consumer_order80.config.ServiceNameProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jon Chan
 * @date 2020/7/23 10:53
 */
@RestController
@Slf4j
@AllArgsConstructor
public class CircleBreakerController {

  public static  final  String SERVICE_URL = "http://nacos-payment-provider";

  private RestTemplate restTemplate;
  private final ServiceNameProperties serviceProperties;


  /**
   * fallback 手动处理运行时异常
   * blockHandler 处理Sentinel控制台配置违规
   *
   * Sentinel控制台规则优先触发
   *
   * exceptionsToIgnore 忽略fallback异常处理
   *
   * @param id
   * @return
   */
  @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback ="handlerFallback")
  @SentinelResource(value = "fallback",fallback ="handlerFallback",blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
  public ResponseEntity<Payment> fallback(@PathVariable Long id) {
    ResponseEntity<Payment> result =  restTemplate.getForEntity(serviceProperties.getProvider() + "/payment/get/" + id, Payment.class);

    if(id == 4){
      throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
    }else if(result.getBody() == null) {
      throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
    }

    return  result;
  }


  /**
   * 服务降级
   * @param id
   * @param e
   * @return
   */
  public ResponseEntity handlerFallback(@PathVariable Long id,Throwable e) {
    Payment payment = new Payment(id,"null");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("异常handlerFallback，exception内容： " + e.getMessage());
  }


  public ResponseEntity blockHandler(@PathVariable Long id, BlockException e) {
    Payment payment = new Payment(id,"null");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("blockHandler-sentinel 限流，BlockException： " + e.getMessage());
  }

}
