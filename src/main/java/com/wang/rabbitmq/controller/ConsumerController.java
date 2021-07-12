package com.wang.rabbitmq.controller;

import com.wang.rabbitmq.component.MQClientMonitor;
import com.wang.rabbitmq.uitls.MQUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author: wangxiaofei
 * @date: 2021年07月05日 10:38:35
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired(required = false)
    private MQClientMonitor mqClientMonitor;

    /**
     * 创建消息队列消费者
     *
     * @return
     */
    @ApiOperation("创建消息队列消费者")
    @GetMapping("createMessageQueueListener")
    public String createMessageQueueListener() {
        mqClientMonitor.createMessageQueueListener();
        return "SUCCESS";
    }


    /**
     * 关闭消息队列消费者
     *
     * @return
     */
    @ApiOperation("关闭消息队列消费者")
    @GetMapping("stopMessageQueueListener")
    public String stopMessageQueueListener() {
        mqClientMonitor.stopMessageQueueListener();
        return "SUCCESS";
    }
}
