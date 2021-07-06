package com.wang.rabbitmq.consumer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author: wangxiaofei
 * @date: 2021年07月02日 16:28:46
 */
@RestController
@RequestMapping("/pull")
public class PullConsumerController {

    public static final String QUEUE_NAME = "chinalife";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/get")
    public String get(){
        System.out.println(rabbitTemplate.receiveAndConvert(QUEUE_NAME));
        return "GET SUCCESS";
    }
}
