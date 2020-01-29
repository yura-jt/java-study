package com.bank.repository;

import com.bank.domain.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudPageableRepository<User> {
    default List<User> findAll() {
        return Collections.emptyList();
    }

    Optional<User> findByEmail(String email);
}