package com.javacourse.task1_1.repository.impl;

import com.javacourse.task1_1.domain.Account;
import com.javacourse.task1_1.repository.AccountRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository {
    private final Map<Integer, Account> accountIdToAccount = new HashMap<>();

    @Override
    public void save(Account account) {
        accountIdToAccount.put(account.getId(), account);
    }

    @Override
    public Account findById(Integer id) {
        return accountIdToAccount.get(id);
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accountIdToAccount.values());
    }

    @Override
    public void update(Account account) {
        accountIdToAccount.put(account.getId(), account);
    }

    @Override
    public void deleteById(Integer id) {
        accountIdToAccount.remove(id);
    }
}