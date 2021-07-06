package com.wang.rabbitmq.uitls;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author: wangxiaofei
 * @date: 2021年07月05日 14:32:00
 */
public class MQUtils {

    public static AtomicReference<SimpleMessageListenerContainer> listenerContainerAtomicReference = new AtomicReference<>();

    public static AtomicReference<RabbitAdmin> rabbitAdminAtomicReference = new AtomicReference<>();

    public static SimpleMessageListenerContainer getMessageListenerContainer(ConnectionFactory connectionFactory) {
        if (Objects.isNull(listenerContainerAtomicReference.get())) {
            SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
            listenerContainerAtomicReference.set(container);
            container.setDefaultRequeueRejected(false);
            container.setAcknowledgeMode(AcknowledgeMode.AUTO);
            return container;
        }
        return listenerContainerAtomicReference.get();
    }

    public static RabbitAdmin getRabbitAdmin(ConnectionFactory connectionFactory) {
        if (Objects.isNull(rabbitAdminAtomicReference.get())) {
            RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
            rabbitAdminAtomicReference.set(rabbitAdmin);
        }
        return rabbitAdminAtomicReference.get();
    }

    public static CachingConnectionFactory getConnectionFactory(String host, Integer port, String userName, String passWord) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(passWord);
        return connectionFactory;
    }
}
