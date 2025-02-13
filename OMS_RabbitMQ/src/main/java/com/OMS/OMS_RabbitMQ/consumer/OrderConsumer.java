package com.OMS.OMS_RabbitMQ.consumer;

import com.OMS.OMS_RabbitMQ.entity.Order;
import com.OMS.OMS_RabbitMQ.exception.DuplicateOrderException;
import com.OMS.OMS_RabbitMQ.exception.InvalidOrderException;
import com.OMS.OMS_RabbitMQ.repository.OrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    @Autowired
    private OrderRepository orderRepository;

    @RabbitListener(queues = "orderQueue")
    public void consumeOrder(Order order) {
        System.out.println("Processing Order: " + order);

        if (order.getQuantity() <= 0) throw new InvalidOrderException("Quantity must be greater than 0");
        if (order.getPrice() <= 0) throw new InvalidOrderException("Price must be greater than 0");

        if (orderRepository.existsByOrderNameAndQuantityAndPrice(order.getOrderName(), order.getQuantity(), order.getPrice())) {
            throw new DuplicateOrderException("Duplicate Order!");
        }

        orderRepository.save(order);
        System.out.println("Order saved to MySQL: " + order);
    }
}
