package com.javacourse.task1_2;

import org.junit.Test;

import static com.javacourse.task1_2.FibonacciNumberUtility.findElementNotRecursively;
import static com.javacourse.task1_2.FibonacciNumberUtility.findElementRecursively;
import static org.junit.Assert.assertEquals;

public class FibonacciNumberUtilityTest {
    @Test
    public void findElementRecursivelyFor1ShouldReturnValidResult() {
        int expected = findElementRecursively(1);
        assertEquals(expected, 1);
    }

    @Test
    public void findElementRecursivelyFor10ShouldReturnValidResult() {
        int expected = findElementRecursively(10);
        assertEquals(expected, 55);
    }

    @Test
    public void findElementRecursively14ShouldReturnValidResult() {
        int expected = findElementRecursively(14);
        assertEquals(expected, 377);
    }

    @Test
    public void findElementNotRecursively1ShouldReturnValidResult() {
        int expected = findElementNotRecursively(1);
        assertEquals(expected, 1);
    }

    @Test
    public void findElementNotRecursively10ShouldReturnValidResult() {
        int expected = findElementNotRecursively(10);
        assertEquals(expected, 55);
    }

    @Test
    public void findElementNotRecursivelyCalc14() {
        int expected = findElementNotRecursively(14);
        assertEquals(expected, 377);
    }
}