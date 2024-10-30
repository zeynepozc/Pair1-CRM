package com.etiya.userservice.core.configuration.exception.type;


public class BusinessException extends RuntimeException
{
    public BusinessException(String message) {
        super(message);
    }
}