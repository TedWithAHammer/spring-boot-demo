package com.leo.rabbitmq;

import com.leo.conf.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by leo.wang on 2017/6/21.
 * Description:
 */
@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE2,containerFactory = "simpleRabbitListenerContainerFactory")
public class Queue2Listener {
    private static Logger logger = LoggerFactory.getLogger(Queue2Listener.class);

    @RabbitHandler
    public void receive(@Payload String s) {
        logger.info("listener2 info: " + s);
    }
}
