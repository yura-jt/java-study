package com.bank.controller;


import java.util.List;

public class StringConverter {
    public static final String DELIMITER = "****************************************************";

    public static <T> String listToString(List<T> list) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (T entity : list) {
            sb.append("\n#").append(count++);
            sb.append(entity).append(DELIMITER);
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}