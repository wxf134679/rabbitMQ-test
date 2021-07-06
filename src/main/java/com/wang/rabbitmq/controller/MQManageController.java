package com.wang.rabbitmq.controller;

import com.wang.rabbitmq.component.MQClientMonitor;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author: wangxiaofei
 * @date: 2021年07月01日 17:09:56
 */
@RestController
@RequestMapping("/mqManage")
public class MQManageController {

    @Autowired(required = false)
    private MQClientMonitor mqClientMonitor;

    /**
     * 重置指定队列消费者数量
     * @param queueName
     * @param concurrentConsumers
     * @return
     */
    @ApiOperation("重置指定队列消费者数量")
    @GetMapping("resetConcurrentConsumers")
    public boolean resetConcurrentConsumers(String queueName, int concurrentConsumers) {
        return mqClientMonitor.resetQueueConcurrentConsumers(queueName, concurrentConsumers);
    }

    /**
     * 重启对消息队列的监听
     * @param queueName
     * @return
     */
    @ApiOperation("重启对消息队列的监听")
    @GetMapping("restartMessageListener")
    public boolean restartMessageListener(String queueName) {
        return mqClientMonitor.restartMessageListener(queueName);
    }

    /**
     * 停止对消息队列的监听
     * @param queueName
     * @return
     */
    @ApiOperation("停止对消息队列的监听")
    @GetMapping("stopMessageListener")
    public boolean stopMessageListener(String queueName) {
        return mqClientMonitor.stopMessageListener(queueName);
    }

    /**
     * 获取所有消息队列对应的消费者
     * @return
     */
    @ApiOperation("统计所有消息队列详情")
    @GetMapping("statAllMessageQueueDetail")
    public List<MQClientMonitor.MessageQueueDatail> statAllMessageQueueDetail() {
        return mqClientMonitor.statAllMessageQueueDetail();
    }

}
