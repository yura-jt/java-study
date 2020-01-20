package com.javacourse.task1_2;

public class FibonacciNumberUtility {
    public static int findElementRecursively(int orderNumber) {
        if (orderNumber == 1 || orderNumber == 2) {
            return 1;
        }
        return findElementRecursively(orderNumber - 1)
                + findElementRecursively(orderNumber - 2);
    }

    public static int findElementNotRecursively(int orderNumber) {
        if (orderNumber == 0 || orderNumber == 1) {
            return orderNumber;
        }

        int first = 0;
        int second = 1;
        int result = 1;

        for (int i = 2; i <= orderNumber; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}