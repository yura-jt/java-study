package com.bank.service.impl;

import com.bank.domain.User;
import com.bank.repository.Page;
import com.bank.repository.UserRepository;
import com.bank.repository.impl.Pageable;
import com.bank.service.PasswordEncryptor;
import com.bank.service.UserService;
import com.bank.service.validator.ValidateException;
import com.bank.service.validator.Validator;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final int USER_PER_PAGE = 5;

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
    public boolean login(String email, String password) {
        validateCredentials(email, password);

        String encryptPassword = passwordEncryptor.encrypt(password);

        return userRepository.findByEmail(email)
                .map(User::getPassword)
                .filter(pass -> pass.equals(encryptPassword))
                .isPresent();
    }

    @Override
    public User register(User user) {
        userValidator.validate(user);

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ValidateException("User with such e-mail is absent");
        }

        User userToPersist = User.builder()
                .withId(user.getId())
                .withEmail(user.getEmail())
                .withPassword(passwordEncryptor.encrypt(user.getPassword()))
                .withAccounts(user.getAccounts())
                .build();

        userRepository.save(userToPersist);

        return userRepository
                .findByEmail(user.getEmail())
                .get();
    }

    @Override
    public List<User> findAll(int page) {
        int maxPage = getMaxPage();
        if (page <= 0) {
            page = 1;
        } else if (page >= maxPage) {
            page = maxPage;
        }

        final Pageable<User> users = userRepository.findAll(new Page(page, USER_PER_PAGE));
        return users.getItems();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    private int getMaxPage() {
        int totalUsers = (int) userRepository.count();
        int pages = totalUsers / USER_PER_PAGE;
        if (totalUsers % USER_PER_PAGE != 0) {
            pages++;
        }
        return pages;
    }

    private void validateCredentials(String email, String password) {
        userValidator.validate(User.builder()
                .withEmail(email)
                .withPassword(password)
                .build());
    }
}