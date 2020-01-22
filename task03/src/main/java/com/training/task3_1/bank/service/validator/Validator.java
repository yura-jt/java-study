package com.training.task3_1.bank.service.validator;

public interface Validator<E> {
    void validate(E entity);
}
