package com.OMS.OMS_RabbitMQ.exception;

public class DuplicateOrderException extends RuntimeException {
    public DuplicateOrderException(String message) {
        super(message);
    }

}
