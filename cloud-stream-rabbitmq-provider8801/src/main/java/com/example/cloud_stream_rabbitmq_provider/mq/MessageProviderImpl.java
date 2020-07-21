package com.example.cloud_stream_rabbitmq_provider.mq;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author Jon Chan
 * @date 2020/7/20 18:06
 */
@EnableBinding(Source.class) //定义消息的推送管道
@AllArgsConstructor
public class MessageProviderImpl implements IMessageProvider {

  /**
   *   private MessageChannel output;
   */
  private MessageChannel output;

  public String send() {
    String serial = UUID.randomUUID().toString();
    output.send(MessageBuilder.withPayload(serial).build());
    System.out.println("*****serial: "  +serial);
    return "SUCCESS";
  }
}
