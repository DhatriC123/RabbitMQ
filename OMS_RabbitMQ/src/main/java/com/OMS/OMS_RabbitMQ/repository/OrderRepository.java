package com.OMS.OMS_RabbitMQ.repository;

import com.OMS.OMS_RabbitMQ.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    boolean existsByOrderNameAndQuantityAndPrice(String orderName, int quantity, double price);
}

