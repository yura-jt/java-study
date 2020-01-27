package com.bank.utility;

import com.bank.domain.Account;
import com.bank.domain.User;

import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {
    private static final String[] E_MAILS = {"joshua.long@gmail.com", "uncle.bob@yahoo.com",
            "erich.gamme@aol.net", "martin.fawler@msn.net", "linus@dev.org"};
    private static final String[] PASSWORDS = {"123456dfT", "trenRer34",
            "sdfsFRret5", "passworD4", "1234567tT"};

    public static List<Account> getRandomAccounts() {
        List<Account> accounts = new ArrayList<>();
        List<User> users = getRandomUsers();
        for (int i = 0; i < users.size(); i++) {
            Account account = new Account(i, users.get(i), i * 10_1000);
            accounts.add(account);
        }
        return accounts;
    }

    public static List<User> getRandomUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < E_MAILS.length; i++) {
            User user = User.builder()
                    .withEmail(E_MAILS[i])
                    .withPassword(PASSWORDS[i])
                    .withAccounts(new ArrayList<>())
                    .build();
            users.add(user);
        }
        return users;
    }
}