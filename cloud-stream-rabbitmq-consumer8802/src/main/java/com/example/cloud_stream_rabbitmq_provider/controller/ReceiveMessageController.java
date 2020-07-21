package com.example.cloud_stream_rabbitmq_provider.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author Jon Chan
 * @date 2020/7/21 09:29
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {

  @Value("${server.port}")
  private  String serverPort;

  @StreamListener(Sink.INPUT)
  public void input(Message<String> message) {
    System.out.println("消费者1号， -----> 接受到的消息： " + message.getPayload()
      + "\t port: " + serverPort);
  }
}
