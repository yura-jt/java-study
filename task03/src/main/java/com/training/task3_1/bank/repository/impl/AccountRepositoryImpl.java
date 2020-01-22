package com.training.task3_1.bank.repository.impl;

import com.training.task3_1.bank.domain.Account;
import com.training.task3_1.bank.repository.AccountRepository;

import java.util.*;

public class AccountRepositoryImpl implements AccountRepository {
    private final Map<Integer, Account> accountIdToAccount = new HashMap<>();

    @Override
    public void save(Account account) {
        accountIdToAccount.put(account.getId(), account);
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.of(accountIdToAccount.get(id));
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
