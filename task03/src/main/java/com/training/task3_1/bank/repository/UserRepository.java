package com.training.task3_1.bank.repository;

import com.training.task3_1.bank.domain.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    Optional<User> findByEmail(String email);
}
