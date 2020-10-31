package com.learning.springboot.domain.exception;


public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
}
