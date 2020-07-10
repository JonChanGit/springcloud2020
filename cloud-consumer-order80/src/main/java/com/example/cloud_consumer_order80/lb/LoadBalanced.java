package com.example.cloud_consumer_order80.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Jon Chan
 * @date 2020/7/10 15:39
 */
public interface LoadBalanced {
  /**
   *  负载均衡轮询算法，rest接口第几次请求数 % 服务器集群总数 = 实际调用服务器位置下标
   * @param serviceInstances
   * @return
   */
  ServiceInstance instances (List<ServiceInstance> serviceInstances);
}
