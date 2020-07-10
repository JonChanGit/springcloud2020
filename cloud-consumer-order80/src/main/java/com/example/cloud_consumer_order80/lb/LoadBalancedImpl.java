package com.example.cloud_consumer_order80.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jon Chan
 * @date 2020/7/10 15:43
 */
@Slf4j
@Component
public class LoadBalancedImpl implements LoadBalanced {


  private AtomicInteger nextServerCyclicCounter;

  public LoadBalancedImpl() {
    this.nextServerCyclicCounter = new AtomicInteger(0);
  }

  public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
    int idx = getAndIncrement() % serviceInstances.size();
    return serviceInstances.get(idx);
  }

  /**
   * 获取第几次访问
   * @return
   */
  public final int getAndIncrement(){
    int current, next;
    do {
      current = nextServerCyclicCounter.get();
      next = current >= Integer.MAX_VALUE ? 0 : current + 1;
    }while (!nextServerCyclicCounter.compareAndSet(current, next));

    log.info("*********** Load Balanced next : {} ", next);
    return next;
  }
}
