package com.example.cloud_stream_rabbitmq_provider.controller;

import com.example.cloud_stream_rabbitmq_provider.mq.IMessageProvider;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jon Chan
 * @date 2020/7/21 09:29
 */
@RestController
@AllArgsConstructor
public class SendMessageController {
  private IMessageProvider messageProvider;

  @GetMapping("/sendMessage")
  public String sendMessage() {
    return messageProvider.send();
  }
}
