package com.javacourse.task1_2;

import static com.javacourse.task1_2.FibonacciNumberUtility.findElementRecursively;
import static com.javacourse.task1_2.FibonacciNumberUtility.findElementNotRecursively;

public class Main {
    public static void main(String[] args) {
        System.out.println(findElementRecursively(10));
        System.out.println(findElementNotRecursively(10));
    }
}