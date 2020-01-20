package com.javacourse.task1_1.repository;

import com.javacourse.task1_1.domain.User;

public interface UserRepository extends CrudRepository<User> {

    User findByEmail(String email);
}