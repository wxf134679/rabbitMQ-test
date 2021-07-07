package com.wang.rabbitmq.consumer.listener;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 清除cache监听器 2019/3/20 19:18
 *
 * @author wangliwei
 */
@Component("consumer5")
public class Consumer5 implements ChannelAwareMessageListener {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer5.class);

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        // 接收MQ消息标识，默认接收成功
        boolean mqFlag = true;
        LOGGER.info("消息接收者接收到来自生产者的消息，消息内容: {}", message);
        long tag = message.getMessageProperties().getDeliveryTag();
        try {
            channel.basicAck(tag, false);
        } catch (Exception e) {
            StringWriter errorStack = new StringWriter();
            PrintWriter printWriter = new PrintWriter(errorStack);
            e.printStackTrace(printWriter);
            LOGGER.error("报错信息如下：" + errorStack.getBuffer().toString());
            // 拒绝消息
            channel.basicReject(tag, false);
        }
    }
}
