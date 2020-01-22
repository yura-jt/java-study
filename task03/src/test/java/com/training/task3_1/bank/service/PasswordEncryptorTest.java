package com.training.task3_1.bank.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PasswordEncryptorTest {
    private PasswordEncryptor passwordEncryptor;

    @Before
    public void init() {
        passwordEncryptor = new PasswordEncryptor();
    }

    @Test
    public void encryptSimplePass() {
        String actualHash = passwordEncryptor.encrypt("PASSWORD");
        assertTrue(passwordEncryptor.validatePassword("PASSWORD", actualHash));
    }

    @Test
    public void encryptSimplePassWithDigits() {
        String actualHash = passwordEncryptor.encrypt("PASSWORDmulti298");
        assertTrue(passwordEncryptor.validatePassword("PASSWORDmulti298", actualHash));
    }

    @Test
    public void encryptLongPassWithDigits() {
        String actualHash = passwordEncryptor.encrypt("PASSWORDmulti298sdfjkehkjUsdlkjhkje9834SD");
        assertTrue(passwordEncryptor.validatePassword("PASSWORDmulti298sdfjkehkjUsdlkjhkje9834SD", actualHash));
    }

    @Test
    public void encryptComplexPass() {
        String actualHash = passwordEncryptor.encrypt("4738hsJfl34Sksdl3_@349");
        assertTrue(passwordEncryptor.validatePassword("4738hsJfl34Sksdl3_@349", actualHash));
    }
}