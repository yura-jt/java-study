package com.bank.repository.impl;

import com.bank.domain.User;
import com.bank.repository.Page;
import com.bank.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    private final Map<Integer, User> userIdToUser = new HashMap<>();

    @Override
    public Optional<User> findByEmail(String email) {
        //validate email
        return userIdToUser.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();
    }

    @Override
    public void save(User entity) {
        Integer id = entity.getId();
        if (id == null) {
            id = (int) count() + 1;
        }
        userIdToUser.put(id, entity);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(userIdToUser.get(id));
    }


    @Override
    public List<User> findAll(int page, int itemPerPage) {
        return findAll(new Page(page, itemPerPage)).getItems();
    }

    @Override
    public Pageable<User> findAll(Page page) {
        int usagePerPage = page.getItemsPerPage();
        int maxPage = getMaxPage(usagePerPage);
        int pageNumber = page.getPageNumber();
        int usersToSkip = (pageNumber - 1) * usagePerPage;

        List<User> users = userIdToUser.values().stream()
                .skip(usersToSkip)
                .limit(usagePerPage)
                .collect(Collectors.toList());

        return new Pageable<>(users, pageNumber, usagePerPage, maxPage);
    }

    @Override
    public long count() {
        return userIdToUser.size();
    }

    @Override
    public void update(User entity) {
        userIdToUser.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(Integer id) {
        userIdToUser.remove(id);
    }

    private int getMaxPage(int usagePerPage) {
        int totalUsers = (int) count();
        int pages = totalUsers / usagePerPage;
        if (totalUsers % usagePerPage != 0) {
            pages++;
        }
        return pages;
    }
}