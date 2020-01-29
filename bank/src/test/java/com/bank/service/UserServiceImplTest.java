package com.bank.service;

import com.bank.domain.User;
import com.bank.repository.Page;
import com.bank.repository.UserRepository;
import com.bank.repository.impl.Pageable;
import com.bank.service.impl.UserServiceImpl;
import com.bank.service.validator.ValidateException;
import com.bank.service.validator.Validator;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final String ENCODED_PASSWORD = "encoded_password";
    private static final Integer USER_ID = 1;
    private static final String PASSWORD = "password";
    private static final String USER_EMAIL = "user@gmail.com";
    private static final String INCORRECT_PASSWORD = "INCORRECT_PASSWORD";
    private static final String ENCODE_INCORRECT_PASSWORD = "encode_incorrect_password";
    private static final Pageable<User> EMPTY_PAGEABLE =
            new Pageable<>(Collections.emptyList(), 1, 5, 1);

    private static final User USER =
            User.builder()
                    .withId(USER_ID)
                    .withEmail(USER_EMAIL)
                    .withPassword(ENCODED_PASSWORD)
                    .build();

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncryptor passwordEncryptor;
    @Mock
    private Validator<User> userValidator;

    @InjectMocks
    private UserServiceImpl userService;

    @After
    public void resetMocks() {
        reset(userRepository, passwordEncryptor, userValidator);
    }

    @Test
    public void userShouldLoginSuccessfully() {
        when(passwordEncryptor.encrypt(eq(PASSWORD))).thenReturn(ENCODED_PASSWORD);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(USER));

        final boolean isLogin = userService.login(USER_EMAIL, PASSWORD);

        assertTrue(isLogin);
        verify(passwordEncryptor).encrypt(eq(PASSWORD));
        verify(userRepository).findByEmail(eq(USER_EMAIL));
    }

    @Test
    public void userShouldNotLoginAsThereIsNotUserWithSuchEmail() {
        when(passwordEncryptor.encrypt(eq(PASSWORD))).thenReturn(ENCODED_PASSWORD);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        final boolean isLogin = userService.login(USER_EMAIL, PASSWORD);

        assertFalse(isLogin);
        verify(passwordEncryptor).encrypt(eq(PASSWORD));
        verify(userRepository).findByEmail(eq(USER_EMAIL));
    }

    @Test
    public void userShouldNotLoginAsPasswordIsIncorrect() {
        when(passwordEncryptor.encrypt(eq(INCORRECT_PASSWORD))).thenReturn(ENCODE_INCORRECT_PASSWORD);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(USER));

        final boolean isLogin = userService.login(USER_EMAIL, INCORRECT_PASSWORD);

        assertFalse(isLogin);
        verify(passwordEncryptor).encrypt(eq("INCORRECT_PASSWORD"));
        verify(userRepository).findByEmail(eq(USER_EMAIL));
    }

    @Test
    public void userShouldRegisterSuccessfully() {
        doNothing().when(userValidator).validate(any(User.class));
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        final User actual = userService.register(USER);

        assertEquals(USER, actual);
        verify(userValidator).validate(any(User.class));
        verify(userRepository).findByEmail(anyString());
        verify(userRepository).save(any(User.class));
    }

    @Test(expected = ValidateException.class)
    public void userShouldNotRegisterWithInvalidPasswordOrEmail() {
        doThrow(ValidateException.class).when(userValidator).validate(any(User.class));

        userService.register(USER);
    }

    @Test(expected = RuntimeException.class)
    public void userShouldNotRegisterAsEmailIsAlreadyUsed() {
        doNothing().when(userValidator).validate(any(User.class));
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(USER));
        doNothing().when(userRepository).save(any(User.class));

        userService.register(USER);
    }

    @Test
    public void findByIdShouldReturnSavedUser() {
        userService.register(USER);
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(USER));

        final User actual = userService.findById(USER_ID);
        assertEquals(USER, actual);
        verify(userRepository).findById(USER_ID);
    }

    @Test
    public void findByIdShouldReturnNull() {
        userService.register(USER);
        when(userRepository.findById(USER_ID + 1)).thenReturn(Optional.empty());

        final User actual = userService.findById(USER_ID + 1);
        assertNull(actual);
        verify(userRepository).findById(USER_ID + 1);
    }

    @Test
    public void findByEmailShouldReturnSavedUser() {
        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(Optional.of(USER));

        final User actual = userService.findByEmail(USER_EMAIL);
        assertEquals(USER, actual);
        verify(userRepository).findByEmail(USER_EMAIL);
    }

    @Test
    public void findByEmailShouldReturnNull() {
        userService.register(USER);
        when(userRepository.findByEmail("1@mail")).thenReturn(Optional.empty());

        final User actual = userService.findByEmail("1@mail");
        assertNull(actual);
        verify(userRepository).findByEmail("1@mail");
    }

    @Test
    public void findAllShouldNotReturnNullIfResultAreAbsent() {
        when(userRepository.findAll(any(Page.class))).thenReturn(EMPTY_PAGEABLE);

        final List<User> actual = userService.findAll(1);
        assertEquals(Collections.EMPTY_LIST, actual);
    }
}