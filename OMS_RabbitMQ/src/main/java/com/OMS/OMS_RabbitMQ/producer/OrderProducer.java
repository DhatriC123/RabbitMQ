package com.OMS.OMS_RabbitMQ.producer;

import com.OMS.OMS_RabbitMQ.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final String EXCHANGE_NAME = "orderExchange";
    private static final String ROUTING_KEY = "orderRoutingKey";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Order order) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, order);
        System.out.println("Order Sent to RabbitMQ Exchange: " + order);
    }
}
