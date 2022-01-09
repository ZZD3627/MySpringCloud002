package com.zzd.stream.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;

@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {


    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者" + serverPort + "号，收到消息：" + message.getPayload());
    }



}
