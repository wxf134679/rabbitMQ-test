package com.wang.rabbitmq.configration;

import com.wang.rabbitmq.consumer.listener.Consumer3;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author: wangxiaofei
 * @date: 2021年07月01日 11:22:45
 */
@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "wang";

    @Autowired
    Consumer3 consumer3;

    @Bean
    public Queue helloQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(consumer3);
        return container;
    }
}
