package com.javacourse.task1_1;

import com.javacourse.task1_1.domain.User;

public class ConsoleApplication {
    public static void main(String[] args) {
        final User user1 = User.builder()
                .withId(1)
                .withEmail("email@gmail.com")
                .withPassword("password")
                .withAccounts(null)
                .build();
    }
}
