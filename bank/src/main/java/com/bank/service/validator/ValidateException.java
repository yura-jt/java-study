package com.bank.service.validator;

public class ValidateException extends RuntimeException {
    public ValidateException(String message) {
        super(message);
    }
}