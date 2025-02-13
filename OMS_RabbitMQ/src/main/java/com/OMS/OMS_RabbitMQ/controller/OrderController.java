package com.OMS.OMS_RabbitMQ.controller;

import com.OMS.OMS_RabbitMQ.entity.Order;
import com.OMS.OMS_RabbitMQ.producer.OrderProducer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/orders")

    public class OrderController{
        @Autowired
        private OrderProducer orderProducer;
        @PostMapping("/create")
        public String createOrder(@Valid @RequestBody Order order){
            orderProducer.sendOrder(order);
            return "order sent";
        }
    }

