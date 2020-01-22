package com.training.task3_1.bank.service.impl;

import com.training.task3_1.bank.domain.User;
import com.training.task3_1.bank.repository.UserRepository;
import com.training.task3_1.bank.service.PasswordEncryptor;
import com.training.task3_1.bank.service.UserService;
import com.training.task3_1.bank.service.validator.Validator;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncryptor passwordEncryptor;
    private final Validator<User> userValidator;

    public UserServiceImpl(UserRepository userRepository, PasswordEncryptor passwordEncryptor,
                           Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncryptor = passwordEncryptor;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password)  {
        return userRepository.findByEmail(email)
                .map(user -> user.getPassword())
                .filter(hash -> passwordEncryptor.validatePassword(password, hash))
                .isPresent();
    }

    @Override
    public User register(User user){
        userValidator.validate(user);
        userRepository.save(user);

        return user;
    }
}
