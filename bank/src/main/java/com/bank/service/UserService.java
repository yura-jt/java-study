package com.bank.service;

import com.bank.domain.User;

import java.util.List;

public interface UserService {

    boolean login(String email, String password);

    User register(User user);

    User findById(int id);

    User findByEmail(String email);

    List<User> findAll(int page);
}