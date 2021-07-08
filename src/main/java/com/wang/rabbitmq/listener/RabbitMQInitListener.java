package com.wang.rabbitmq.listener;

import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author: wangxiaofei
 * @date: 2021年07月08日 15:24:18
 */
@Component
public class RabbitMQInitListener implements ApplicationRunner {

    @Autowired
    private RabbitListenerEndpointRegistry registry;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //得到容器的对象
        Collection<MessageListenerContainer> containers = registry.getListenerContainers();
        containers.forEach(container -> {
            if (!container.isRunning()) {
                //开启容器
//                container.start();
//                System.out.println("开启容器:" + container.toString());
            }
        });
    }
}
