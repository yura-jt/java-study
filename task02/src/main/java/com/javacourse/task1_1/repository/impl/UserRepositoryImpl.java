package com.javacourse.task1_1.repository.impl;

import com.javacourse.task1_1.domain.User;
import com.javacourse.task1_1.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    private final Map<Integer, User> userIdToUser = new HashMap<>();

    @Override
    public User findByEmail(String email) {
        return userIdToUser.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(User entity) {
        userIdToUser.put(entity.getId(), entity);
    }

    @Override
    public User findById(Integer id) {
        return userIdToUser.get(id);
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