package com.example.cloud_gateway_gateway9527.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 测试URL：
 *    通过： http://127.0.0.1:9527/ok/1?uname=111
 *    拒绝： http://127.0.0.1:9527/ok/1
 * @author Jon Chan
 * @date 2020/7/13 10:23
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    log.info("****** come in MyLogGateWayFilter: " + LocalDateTime.now());

    String uname = exchange.getRequest().getQueryParams().getFirst("uname");
    if (Objects.isNull(uname)) {
      log.warn("*****用户名为null，非法用户，o(╥﹏╥)o");
      exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
      return exchange.getResponse().setComplete();
    }
    log.info("*****用户名为{}", uname);
    // 放行
    return chain.filter(exchange);
  }

  /**
   * 加载过滤器的顺序，数字越小，优先级越高
   *
   * @return
   */
  @Override
  public int getOrder() {
    return 0;
  }
}
