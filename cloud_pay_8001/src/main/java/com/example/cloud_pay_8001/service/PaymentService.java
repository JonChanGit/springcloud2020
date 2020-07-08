package com.example.cloud_pay_8001.service;

import com.example.cloud_pay_8001.dao.PaymentDao;
import com.example.cloud_pay_8001.entity.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Jon Chan
 * @date 2020/7/8 8:43
 */
@Service
@AllArgsConstructor
public class PaymentService {
  private PaymentDao paymentDao;

  public void create(Payment payment){
    paymentDao.insert(payment);
  }

  public Payment getPaymentById(Long id){
    return paymentDao.findById(id);
  }
}
