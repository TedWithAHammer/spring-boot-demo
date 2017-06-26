package com.leo.rabbitmq;

import com.leo.conf.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by leo.wang on 2017/6/21.
 * Description:
 */
@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE1, containerFactory = "simpleRabbitListenerContainerFactory")
public class Queue1Listener implements ChannelAwareMessageListener {
    private static Logger logger = LoggerFactory.getLogger(Queue1Listener.class);

    @RabbitHandler
    public void receive(@Payload String s) {
        logger.info("listener1 info: " + s);
    }

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        logger.info("listener1 receive:" + message);
    }
}
