package com.bank.repository.impl;

import com.bank.domain.User;
import com.bank.repository.Page;
import com.bank.repository.UserRepository;
import com.bank.utility.TestDataGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserRepositoryImplTest {
    private static final List<User> USERS = TestDataGenerator.getRandomUsers();
    private UserRepository userRepository;

    @Before
    public void init() {
        userRepository = new UserRepositoryImpl();
        USERS.forEach(user -> userRepository.save(user));
    }

    @Test
    public void findAllShouldReturnValidPageableForFirstPage() {
        List<User> expected = new ArrayList<>(Arrays.asList(USERS.get(0), USERS.get(1)));
        List<User> actual = userRepository
                .findAll(new Page(1, 2))
                .getItems();
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnValidPageableForMiddlePage() {
        List<User> expected = new ArrayList<>(Arrays.asList(USERS.get(2), USERS.get(3)));
        List<User> actual = userRepository
                .findAll(new Page(2, 2))
                .getItems();
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnValidPageableForLastPage() {
        List<User> expected = new ArrayList<>(Arrays.asList(USERS.get(4)));
        List<User> actual = userRepository
                .findAll(new Page(3, 2))
                .getItems();
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnValidListForFirstPage() {
        List<User> expected = new ArrayList<>(Arrays.asList(USERS.get(0), USERS.get(1)));
        List<User> actual = userRepository
                .findAll(1, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnValidListForMiddlePage() {
        List<User> expected = new ArrayList<>(Arrays.asList(USERS.get(2), USERS.get(3)));
        List<User> actual = userRepository
                .findAll(2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnValidListForLastPage() {
        List<User> expected = new ArrayList<>(Arrays.asList(USERS.get(4)));
        List<User> actual = userRepository
                .findAll(3, 2);
        assertEquals(expected, actual);
    }
}