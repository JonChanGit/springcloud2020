package com.example.cloud_pay_8001.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Jon Chan
 * @date 2020/7/7 16:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
  Long id;
  String serial;
}
