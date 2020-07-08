package com.example.cloud_pay_8006.dao;

import com.example.cloud_api_commons.entity.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author Jon Chan
 * @date 2020/7/7 16:42
 */
@Mapper
public interface PaymentDao {
  @Insert("INSERT INTO `payment`(`id`, `serial`) VALUES (#{id}, #{serial})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(Payment city);

  @Select("SELECT * FROM `payment` WHERE id = #{id}")
  Payment findById(long id);
}
