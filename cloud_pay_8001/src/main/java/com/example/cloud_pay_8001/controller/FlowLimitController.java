package com.example.cloud_pay_8001.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Jon Chan
 * @date 2020/7/22 08:54
 */
@RestController
@Slf4j
public class FlowLimitController {

  @GetMapping("/testA")
  public String testA() {
    return "----testA";
  }

  @GetMapping("/testB")
  public String testB() {
    return "----testB";
  }


  /**
   * 平均需要时间测试（服务降级 - RT）
   * @return
   */
  @GetMapping("/testD")
  public String testD() {
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("testD 测试RT");
    return "----testD";
  }


  /**
   * 异常降级（服务降级 - 异常比例）
   * @return
   */
  @GetMapping("/testE")
  public String testE() {
    log.info("testE 测试异常数");
    int age = 10 / 0;
    return "----testE 测试异常数";
  }


  /**
   * 热点限流测试
   *
   * 配置界面上的index是指方法列表的参数顺序下标
   *
   * 当只配置index=0时，访问
   *    http://127.0.0.1:8001/testHotKey?p1=x
   *    http://127.0.0.1:8001/testHotKey?p1=x&p2=y
   * 会被限流
   *
   * 若访问参数不包含p1则不限流
   *
   * @param p1
   * @param p2
   * @return
   */
  @GetMapping("/testHotKey")
  @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
  public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                           @RequestParam(value = "p2",required = false)String p2) {
    // int age = 10 / 0; // 运行时错误不会使用blockHandler处理。需要使用 fallback 处理
    return "----testHotKey";
  }

  /**
   * testHotKey(...) 失败时的处理方法
   * @param p1
   * @param p2
   * @param exception
   * @return
   */
  public String deal_testHotKey(String p1, String p2, BlockException exception) {
    return "----deal_testHotKey, o(╥﹏╥)o"; // sentinel的默认提示都是： Blocked by Sentinel (flow limiting)
  }

}
