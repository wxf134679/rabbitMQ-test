package com.wang.rabbitmq.consumer.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author: wangxiaofei
 * @date: 2021年07月01日 11:21:43
 */
@Component
@RabbitListener(queues = "wang", autoStartup = "false")
public class Consumer1 {

    @RabbitHandler
    public void process(String s, Message message, Channel channel) {
        System.out.println("Receiver1:" + s);
    }
}
