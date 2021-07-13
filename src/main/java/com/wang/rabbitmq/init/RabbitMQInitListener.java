package com.wang.rabbitmq.init;

import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * MQ监听动态启动，在项目启动后再启动MQ监听
 *
 * @author: wangxiaofei
 * @date: 2021年07月08日 15:24:18
 */
@Component
public class RabbitMQInitListener implements ApplicationRunner {

    @Autowired
    private RabbitListenerEndpointRegistry registry;

    @Resource
    private Collection<SimpleMessageListenerContainer> consumerListenerContainer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //得到容器的对象
        //可获取到根据注解@RabbitListener定义的监听器，此处是Consumer1.java
        Collection<MessageListenerContainer> containers = registry.getListenerContainers();
        containers.forEach(container -> {
            if (!container.isRunning()) {
                //开启容器
                container.start();
            }
        });

        //这里的Bean consumerListenerContainer取的是xml配置的监听器，且auto-startup=false，这里是consumer6/consumer7
        consumerListenerContainer.forEach(SimpleMessageListenerContainer::start);
    }
}
