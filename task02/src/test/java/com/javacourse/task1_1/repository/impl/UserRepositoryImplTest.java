package com.javacourse.task1_1.repository.impl;

import com.javacourse.task1_1.domain.Account;
import com.javacourse.task1_1.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class UserRepositoryImplTest {
    private UserRepositoryImpl userRepository;

    @Before
    public void initRepository() {
        userRepository = new UserRepositoryImpl();

        for (int i = 1; i <= 3; i++) {
            User user = User.builder()
                    .withId(i)
                    .withEmail(String.format("email_%d@gmail.com", i))
                    .withPassword("password")
                    .withAccounts(new ArrayList<>())
                    .build();
            userRepository.save(user);
        }
    }

    @Test
    public void findByNonExistEmailShouldReturnNull() {
        User actual = userRepository.findByEmail("gojira@softbank.ne.jp");
        assertNull(actual);
    }

    @Test
    public void findByExistEmailShouldReturnProperResult() {
        User actual = userRepository.findByEmail("email_3@gmail.com");
        assertEquals((long) actual.getId(), 3);
    }


    @Test
    public void saveShouldPutUserToRepository() {
        User expected = User.builder()
                .withId(25)
                .withEmail("email@gmail.com")
                .withPassword("password")
                .withAccounts(new ArrayList<>())
                .build();

        userRepository.save(expected);
        User actual = userRepository.findById(25);

        assertEquals(actual, expected);
        assertEquals(userRepository.findAll().size(), 4);
    }

    @Test
    public void findByExistIdShouldReturnValidUser() {
        User actual = userRepository.findById(2);
        assertEquals(2, (long) actual.getId());
        assertEquals("email_2@gmail.com", actual.getEmail());
    }

    @Test
    public void findByNonExistIdShouldReturnNull() {
        User actual = userRepository.findById(45);
        assertNull(actual);
    }


    @Test
    public void findAllMethodShouldReturnEmptyList() {
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        List<Account> actual = accountRepository.findAll();
        assertTrue(actual.isEmpty());
    }

    @Test
    public void findAllMethodShouldReturnAllUsers() {
        List<User> actual = userRepository.findAll();
        assertEquals(3, actual.size());
    }

    @Test
    public void updateShouldModifyUser() {
        User expected = User.builder()
                .withId(3)
                .withEmail("email25@gmail.com")
                .withPassword("password")
                .withAccounts(new ArrayList<>())
                .build();
        userRepository.update(expected);
        User actual = userRepository.findById(3);

        assertEquals(actual, expected);
        assertEquals(actual.getEmail(), "email25@gmail.com");
        assertEquals(userRepository.findAll().size(), 3);
    }

    @Test
    public void deleteUserById() {
        userRepository.deleteById(2);
        assertEquals(userRepository.findAll().size(), 2);
        assertNull(userRepository.findById(2));
    }
}