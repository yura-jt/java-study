package com.training.task3_1.bank.service;

import com.training.task3_1.bank.domain.User;

public interface UserService {

    boolean login(String email, String password);

    User register(User user);
}
