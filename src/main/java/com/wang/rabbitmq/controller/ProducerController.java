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

    public static final String QUEUE_NAME = "wang";
    public static final String EXCHANGE_NAME = "exchange_anonymous";

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

    @GetMapping("/sendEXChange")
    public String sendEXChange() {
        String context = "hello rabbit : ";
        for (int i = 0; i < 100; i++) {
            this.rabbitTemplate.convertAndSend(EXCHANGE_NAME, "*", context + i);
            System.out.println("Sender:" + context + i);
        }
        return "SUCCESS";
    }

    @GetMapping("/send6")
    public String send6() {
        String context = "hello rabbit : ";
        for (int i = 0; i < 100; i++) {
            this.rabbitTemplate.convertAndSend("MESSAGE_QUEUE_6", context + i);
            System.out.println("Sender6:" + context + i);
        }
        return "SUCCESS";
    }


    @GetMapping("/send7")
    public String send7() {
        String context = "hello rabbit : ";
        for (int i = 0; i < 100; i++) {
            this.rabbitTemplate.convertAndSend("MESSAGE_QUEUE_7", context + i);
            System.out.println("Sender7:" + context + i);
        }
        return "SUCCESS";
    }
}
