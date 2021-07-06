package com.wang.rabbitmq.consumer.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author: wangxiaofei
 * @date: 2021年07月05日 10:13:14
 */
@Component
public class Consumer4 implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("Receiver4:" + new String(message.getBody()));
    }
}
