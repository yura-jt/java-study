package com.training.task3_1.bank.injector;

import com.training.task3_1.bank.domain.User;
import com.training.task3_1.bank.repository.UserRepository;
import com.training.task3_1.bank.repository.impl.UserRepositoryImpl;
import com.training.task3_1.bank.service.PasswordEncryptor;
import com.training.task3_1.bank.service.UserService;
import com.training.task3_1.bank.service.impl.UserServiceImpl;
import com.training.task3_1.bank.service.validator.UserValidator;
import com.training.task3_1.bank.service.validator.Validator;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncryptor PASSWORD_ENCRYPTOR = new PasswordEncryptor();

    private static final UserRepository USER_REPOSITORY = new UserRepositoryImpl();

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRYPTOR, USER_VALIDATOR);

    private ApplicationInjector() {
    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public UserService getUserService(){
        return USER_SERVICE;
    }
}
