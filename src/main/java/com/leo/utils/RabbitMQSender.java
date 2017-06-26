package com.leo.utils;

import com.leo.conf.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by leo.wang on 2017/6/21.
 * Description:
 */
@Component
public class RabbitMQSender implements RabbitTemplate.ConfirmCallback {
    private static Logger logger = LoggerFactory.getLogger(RabbitMQSender.class.getSimpleName());
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {

    }

    public void send2Queue1(Object msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EX_CHANGE_NAME1, RabbitMQConfig.ROUTING_KEY1, msg);
    }

    public void send2Queue2(Object msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EX_CHANGE_NAME1, RabbitMQConfig.ROUTING_KEY2, msg);
    }

    public void send2Queue3(Object msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EX_CHANGE_NAME1, RabbitMQConfig.ROUTING_KEY3, msg);
    }

    public void send(String exchangeName, String routingKey, Object msg, CorrelationData correlationData) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, msg, correlationData);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println(s);
        logger.info("callback : " + s);
    }
}
