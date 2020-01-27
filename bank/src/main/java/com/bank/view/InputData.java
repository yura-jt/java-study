package com.bank.view;

import java.util.Scanner;

public class InputData {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String input() {
        System.out.print("-> ");
        return SCANNER.nextLine();
    }
}