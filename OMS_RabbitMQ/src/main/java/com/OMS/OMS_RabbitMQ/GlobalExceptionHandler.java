package com.OMS.OMS_RabbitMQ;

import com.OMS.OMS_RabbitMQ.exception.DuplicateOrderException;
import com.OMS.OMS_RabbitMQ.exception.InvalidOrderException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateOrderException.class)
    @ResponseStatus(HttpStatus.CONFLICT)  // 409 Conflict
    public String handleDuplicateOrderException(DuplicateOrderException e) {
        return e.getMessage();  // Returns "Duplicate Order!"
    }

    @ExceptionHandler(InvalidOrderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // 400 Bad Request
    public String handleInvalidOrderException(InvalidOrderException e) {
        return e.getMessage();  // Returns "Quantity must be greater than 0"
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 500 Internal Server Error
    public String handleGeneralException(Exception e) {
        return "An unexpected error occurred: " + e.getMessage();
    }
}
