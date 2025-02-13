package com.OMS.OMS_RabbitMQ.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import jakarta.persistence.Id;


@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @jakarta.persistence.Column(nullable = false)
    private String orderName;

    @jakarta.persistence.Column(nullable = false)
    private int quantity;

    @jakarta.persistence.Column(nullable = false)
    private double price;
}