package com.leo.conf;

import com.leo.rabbitmq.Queue3Listener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by leo.wang on 2017/6/21.
 * Description:
 */
@Configuration
public class RabbitMQConfig {
    public static final String EX_CHANGE_NAME1 = "ex_change1";

    public static final String QUEUE1 = "queue1";
    public static final String QUEUE2 = "queue2";
    public static final String QUEUE3 = "queue3";

    public static final String ROUTING_KEY1 = "routing_key1";
    public static final String ROUTING_KEY2 = "routing_key2";
    public static final String ROUTING_KEY3 = "routing_key3";


    @Autowired
    private ConnectionFactory connectionFactory;
    @Autowired
    private Queue3Listener queue3Listener;

    @Bean
    @Primary
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    @Primary
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setMessageConverter(new Jackson2JsonMessageConverter());
        return simpleRabbitListenerContainerFactory;
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(queue3());
        container.setMessageListener(queue3Listener);
        return container;
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EX_CHANGE_NAME1);
    }

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE1, true);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE2, true);
    }

    @Bean
    public Queue queue3() {
        return new Queue(QUEUE3, true);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(directExchange()).with(ROUTING_KEY1);
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(directExchange()).with(ROUTING_KEY2);

    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(directExchange()).with(ROUTING_KEY3);
    }
}
