package com.leo.rabbitmq;

import com.rabbitmq.client.Channel;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by leo.wang on 2017/6/26.
 * Description:
 */
@Component
public class Queue3Listener implements ChannelAwareMessageListener {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(Queue3Listener.class);

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        logger.info("Queue3Listener: " + message);
    }
}
