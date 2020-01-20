package com.javacourse.task1_3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FactorialUtility {
    public static String customFactorialCalc(int number) {
        String result = "1";
        for (int i = 1; i <= number; i++) {
            result = longNumberMultiply(result, String.valueOf(i));
        }
        return result;
    }

    public static BigInteger bigIntegerFactorialCalc(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private static String longNumberMultiply(String number1, String number2) {
        int product = 0;
        int carry = 0;
        int sum = 0;

        String result = "";
        String partial = "";
        List<String> partialList = new ArrayList<>();

        for (int j = number2.length() - 1; j >= 0; j--) {
            for (int i = number1.length() - 1; i >= 0; i--) {
                product = Integer.parseInt(Character.toString(number1.charAt(i))) *
                        Integer.parseInt(Character.toString(number2.charAt(j))) + carry;
                carry = product / 10;
                partial = (product % 10) + partial;
            }

            if (carry != 0) {
                partial = (carry) + partial;
            }

            partialList.add(partial);
            partial = "";
            carry = 0;
        }

        for (int i = 0; i < partialList.size(); i++) {
            partialList.set(i, partialList.get(i) + (Long.toString((long) java.lang.Math.pow(10.0, i))).substring(1));
        }

        int largestPartial = partialList.get(partialList.size() - 1).length();

        int zeroes;
        for (int i = 0; i < partialList.size(); i++) {
            zeroes = largestPartial - partialList.get(i).length();

            if (zeroes >= 1) {
                partialList.set(i, (Long.toString((long) java.lang.Math.pow(10.0, zeroes))).substring(1) + partialList.get(i));
            }
        }

        carry = 0;
        for (int i = largestPartial - 1; i >= 0; i--) {
            sum = 0;
            for (int j = 0; j < partialList.size(); j++) {
                sum = sum + Integer.parseInt(Character.toString(partialList.get(j).charAt(i)));
            }

            sum = sum + carry;
            carry = sum / 10;
            result = (sum % 10) + result;
        }

        if (carry != 0) {
            result = (carry) + result;
        }

        return result;
    }
}