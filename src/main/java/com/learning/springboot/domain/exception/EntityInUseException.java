package com.learning.springboot.domain.exception;

public class EntityInUseException extends BusinessException {

    public EntityInUseException(String message, Throwable cause) {
        super(message, cause);
    }
}
