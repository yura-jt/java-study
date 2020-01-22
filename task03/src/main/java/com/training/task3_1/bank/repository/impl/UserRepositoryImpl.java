package com.training.task3_1.bank.repository.impl;

import com.training.task3_1.bank.domain.User;
import com.training.task3_1.bank.repository.UserRepository;

import java.util.*;

public class UserRepositoryImpl implements UserRepository {
    private final Map<Integer, User> userIdToUser = new HashMap<>();

    @Override
    public Optional<User> findByEmail(String email) {
        return userIdToUser.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public void save(User entity) {
        userIdToUser.put(entity.getId(), entity);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.of(userIdToUser.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userIdToUser.values());
    }

    @Override
    public void update(User entity) {
        userIdToUser.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(Integer id) {
        userIdToUser.remove(id);
    }
}