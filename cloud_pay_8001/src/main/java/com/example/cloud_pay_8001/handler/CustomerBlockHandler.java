package com.example.cloud_pay_8001.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.cloud_api_commons.entity.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Jon Chan
 * @date 2020/7/22 14:53
 */
public class CustomerBlockHandler {
  public static ResponseEntity handlerException(BlockException exception) {
    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("按照客户自定义的Glogal 全局异常处理 ---- 1");
  }

  public static ResponseEntity handlerException2(BlockException exception) {
    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("按照客户自定义的Glogal 全局异常处理 ---- 2");
  }
}
