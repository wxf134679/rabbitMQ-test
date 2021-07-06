package com.wang.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author: wangxiaofei
 * @date: 2021年07月01日 11:18:30
 */

@RestController
@RequestMapping("/producer")
public class ProducerController {

    public static final String QUEUE_NAME = "chinalife";

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @GetMapping("/send")
    public String send() {
        String context = "hello rabbit : ";
        for (int i = 0; i < 100; i++) {
            this.rabbitTemplate.convertAndSend(QUEUE_NAME, context + i);
            System.out.println("Sender:" + context + i);
        }
        return "SUCCESS";
    }
}
