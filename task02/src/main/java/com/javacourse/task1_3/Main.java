package com.javacourse.task1_3;

import static com.javacourse.task1_3.FactorialUtility.bigIntegerFactorialCalc;
import static com.javacourse.task1_3.FactorialUtility.customFactorialCalc;

public class Main {
    public static void main(String[] args) {
        System.out.println(customFactorialCalc(27));
        System.out.println(bigIntegerFactorialCalc(27));
    }
}