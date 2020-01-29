package com.bank.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validator {
    private static final Logger LOGGER = LogManager.getLogger(Validator.class);

    static boolean isValidString(String str) {
        return str != null && str.length() >= 1;
    }

    static boolean isValidIntForMenu(String str, int upLimit) {
        int key = 0;
        boolean isValidInt = false;
        try {
            key = Integer.parseInt(str);
            isValidInt = true;
        } catch (NumberFormatException e) {
            LOGGER.warn(e);
        }
        if (!isValidInt) {
            return false;
        }
        return key > 0 && key <= upLimit;
    }
}