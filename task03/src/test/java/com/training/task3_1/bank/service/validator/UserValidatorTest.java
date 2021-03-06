package com.training.task3_1.bank.service.validator;

import com.training.task3_1.bank.domain.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class UserValidatorTest {
    private UserValidator userValidator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void init() {
        userValidator = new UserValidator();
    }

    @Test
    public void validateEmailShouldThrowExceptionWhenEmailOnlyNumbers() {
        User user = User.builder()
                .withId(25)
                .withEmail("12345678")
                .withPassword("Password1234")
                .withAccounts(new ArrayList<>())
                .build();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("E-Mail is not match to requirements");
        userValidator.validate(user);
    }

    @Test
    public void validateEmailShouldThrowExceptionWhenEmailOnlyNumbersAndLetters() {
        User user = User.builder()
                .withId(25)
                .withEmail("12345678abcdef")
                .withPassword("Password1234")
                .withAccounts(new ArrayList<>())
                .build();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("E-Mail is not match to requirements");
        userValidator.validate(user);
    }

    @Test
    public void validateEmailShouldThrowExceptionWhenEmailWithoutAtSign() {
        User user = User.builder()
                .withId(25)
                .withEmail("usergmail.com")
                .withPassword("Password1234")
                .withAccounts(new ArrayList<>())
                .build();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("E-Mail is not match to requirements");
        userValidator.validate(user);
    }

    @Test
    public void validateEmailShouldPassedWithoutExceptionIfEmailIsValid() {
        User user = User.builder()
                .withId(25)
                .withEmail("email@gmail.com")
                .withPassword("Password1234")
                .withAccounts(new ArrayList<>())
                .build();
        userValidator.validate(user);
    }

    @Test
    public void validatePasswordShouldThrowExceptionWhenPasswordOnlyNumbers() {
        User user = User.builder()
                .withId(25)
                .withEmail("email@gmail.com")
                .withPassword("12345678910")
                .withAccounts(new ArrayList<>())
                .build();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Password is not match to requirements");
        userValidator.validate(user);
    }

    @Test
    public void validatePasswordShouldThrowExceptionWhenPasswordOnlyLetter() {
        User user = User.builder()
                .withId(25)
                .withEmail("email@gmail.com")
                .withPassword("abcdefghaijk")
                .withAccounts(new ArrayList<>())
                .build();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Password is not match to requirements");
        userValidator.validate(user);
    }

    @Test
    public void validatePasswordShouldThrowExceptionWhenPasswordLengthTooSmall() {
        User user = User.builder()
                .withId(25)
                .withEmail("email@gmail.com")
                .withPassword("aB9")
                .withAccounts(new ArrayList<>())
                .build();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Password is not match to requirements");
        userValidator.validate(user);
    }

    @Test
    public void validatePasswordShouldThrowExceptionWhenPasswordLengthTooLarge() {
        User user = User.builder()
                .withId(25)
                .withEmail("email@gmail.com")
                .withPassword("abcdefghPASSWROD123456789A")
                .withAccounts(new ArrayList<>())
                .build();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Password is not match to requirements");
        userValidator.validate(user);
    }

    @Test
    public void validatePasswordShouldPassIfPasswordMatchesRequirements() {
        User user = User.builder()
                .withId(25)
                .withEmail("email@gmail.com")
                .withPassword("Password1234")
                .withAccounts(new ArrayList<>())
                .build();

        userValidator.validate(user);
    }
}