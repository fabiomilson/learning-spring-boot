package com.learning.springboot.domain.exception;

public class BusinessException extends Exception {

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
