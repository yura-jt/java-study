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


public class AccountRepositoryImplTest {

    private AccountRepositoryImpl accountRepository;

    @Before
    public void initRepository() {
        accountRepository = new AccountRepositoryImpl();

        for (int i = 1; i <= 3; i++) {
            User user = User.builder()
                    .withId(i)
                    .withEmail(String.format("email%d@gmail.com", i))
                    .withPassword("password")
                    .withAccounts(new ArrayList<>())
                    .build();
            Account account = new Account(i, user, 10_000 * i);
            accountRepository.save(account);
        }
    }

    @Test
    public void saveShouldPutAccountToRepository() {
        User user = User.builder()
                .withId(25)
                .withEmail("email@gmail.com")
                .withPassword("password")
                .withAccounts(new ArrayList<>())
                .build();
        Account expected = new Account(25, user, 99_000);
        accountRepository.save(expected);
        Account actual = accountRepository.findById(25);

        assertEquals(actual, expected);
        assertEquals(accountRepository.findAll().size(), 4);
    }

    @Test
    public void findByExistIdShouldReturnValidAccount() {
        Account actual = accountRepository.findById(2);
        assertEquals(2, (long) actual.getId());
        assertEquals("email2@gmail.com", actual.getUser().getEmail());
    }

    @Test
    public void findByNonExistIdShouldReturnNull() {
        Account actual = accountRepository.findById(45);
        assertNull(actual);
    }


    @Test
    public void findAllMethodShouldReturnEmptyList() {
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        List<Account> actual = accountRepository.findAll();
        assertTrue(actual.isEmpty());
    }

    @Test
    public void findAllMethodShouldReturnAllAccounts() {
        List<Account> actual = accountRepository.findAll();
        assertEquals(3, actual.size());
    }

    @Test
    public void updateShouldModifyAccount() {
        User user = User.builder()
                .withId(3)
                .withEmail("email25@gmail.com")
                .withPassword("password")
                .withAccounts(new ArrayList<>())
                .build();
        Account expected = new Account(3, user, 99_000);
        accountRepository.update(expected);
        Account actual = accountRepository.findById(3);

        assertEquals(actual, expected);
        assertEquals(actual.getUser().getEmail(), "email25@gmail.com");
        assertEquals((long) actual.getMoney(), 99_000);
        assertEquals(accountRepository.findAll().size(), 3);
    }

    @Test
    public void deleteAccountById() {
        accountRepository.deleteById(2);
        assertEquals(accountRepository.findAll().size(), 2);
        assertNull( accountRepository.findById(2));
    }
}