package com.bank.repository.impl;

import com.bank.domain.Account;
import com.bank.repository.AccountRepository;
import com.bank.repository.Page;

import java.util.*;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
    private final Map<Integer, Account> accountIdToAccount = new HashMap<>();

    @Override
    public void save(Account entity) {
        accountIdToAccount.put(entity.getId(), entity);
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.ofNullable(accountIdToAccount.get(id));
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accountIdToAccount.values());
    }

    @Override
    public Pageable<Account> findAll(Page page) {
        int usagePerPage = page.getItemsPerPage();
        int maxPage = getMaxPage(usagePerPage);
        int pageNumber = page.getPageNumber();
        int usersToSkip = (pageNumber - 1) * usagePerPage;

        List<Account> users = accountIdToAccount.values().stream()
                .skip(usersToSkip)
                .limit(usagePerPage)
                .collect(Collectors.toList());

        return new Pageable<>(users, pageNumber, usagePerPage, maxPage);
    }

    private int getMaxPage(int usagePerPage) {
        int totalUsers = (int) count();
        int pages = totalUsers / usagePerPage;
        if (totalUsers % usagePerPage != 0) {
            pages++;
        }
        return pages;
    }

    @Override
    public long count() {
        return accountIdToAccount.size();
    }

    @Override
    public void update(Account entity) {
        accountIdToAccount.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(Integer id) {
        accountIdToAccount.remove(id);
    }
}