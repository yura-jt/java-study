package com.bank.repository.impl;

import com.bank.domain.Account;
import com.bank.repository.AccountRepository;
import com.bank.repository.Page;
import com.bank.utility.TestDataGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountRepositoryImplTest {
    private static final List<Account> ACCOUNTS = TestDataGenerator.getRandomAccounts();
    private AccountRepository accountRepository;

    @Before
    public void init() {
        accountRepository = new AccountRepositoryImpl();
        ACCOUNTS.forEach(account -> accountRepository.save(account));
    }

    @Test
    public void findAllShouldReturnValidPageableForFirstPage() {
        List<Account> expected = new ArrayList<>(Arrays.asList(ACCOUNTS.get(0), ACCOUNTS.get(1)));
        List<Account> actual = accountRepository
                .findAll(new Page(1, 2))
                .getItems();
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnValidPageableForMiddlePage() {
        List<Account> expected = new ArrayList<>(Arrays.asList(ACCOUNTS.get(2), ACCOUNTS.get(3)));
        List<Account> actual = accountRepository
                .findAll(new Page(2, 2))
                .getItems();
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnValidPageableForLastPage() {
        List<Account> expected = new ArrayList<>(Arrays.asList(ACCOUNTS.get(4)));
        List<Account> actual = accountRepository
                .findAll(new Page(3, 2))
                .getItems();
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnValidListForFirstPage() {
        List<Account> expected = new ArrayList<>(Arrays.asList(ACCOUNTS.get(0), ACCOUNTS.get(1)));
        List<Account> actual = accountRepository
                .findAll(1, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnValidListForMiddlePage() {
        List<Account> expected = new ArrayList<>(Arrays.asList(ACCOUNTS.get(2), ACCOUNTS.get(3)));
        List<Account> actual = accountRepository
                .findAll(2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnValidListForLastPage() {
        List<Account> expected = new ArrayList<>(Arrays.asList(ACCOUNTS.get(4)));
        List<Account> actual = accountRepository
                .findAll(3, 2);
        assertEquals(expected, actual);
    }
}