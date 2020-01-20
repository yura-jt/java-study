package com.javacourse.task1_4;

import org.junit.Assert;
import org.junit.Test;

public class ArraySortUtilTest {

    @Test
    public void bubbleSortTestWith1Element() {
        int[] actual = {54};
        int[] expected = {54};
        ArraySortUtil.bubbleSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void bubbleSortTestWith2Element() {
        int[] actual = {10, -5};
        int[] expected = {-5, 10};
        ArraySortUtil.bubbleSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void bubbleSortTestWith9Element() {
        int[] actual = {1, 5, 9, 4, 7, 3, 2, 8, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArraySortUtil.bubbleSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void bubbleSortTestWithRepeatableElements() {
        int[] actual = {1, 5, 9, 1, 4, 7, 3, 2, 8, 8, -6};
        int[] expected = {-6, 1, 1, 2, 3, 4, 5, 7, 8, 8, 9};
        ArraySortUtil.bubbleSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void selectionSortTestWith1Element() {
        int[] actual = {54};
        int[] expected = {54};
        ArraySortUtil.selectionSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void selectionSortTestWith2Element() {
        int[] actual = {10, -5};
        int[] expected = {-5, 10};
        ArraySortUtil.selectionSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void selectionSortTestWith9Element() {
        int[] actual = {1, 5, 9, 4, 7, 3, 2, 8, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArraySortUtil.selectionSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void selectionSortTestWithRepeatableElements() {
        int[] actual = {1, 5, 9, 1, 4, 7, 3, 2, 8, 8, -6};
        int[] expected = {-6, 1, 1, 2, 3, 4, 5, 7, 8, 8, 9};
        ArraySortUtil.selectionSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void insertSortTestWith1Element() {
        int[] actual = {54};
        int[] expected = {54};
        ArraySortUtil.insertSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void insertSortTestWith2Element() {
        int[] actual = {10, -5};
        int[] expected = {-5, 10};
        ArraySortUtil.insertSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void insertSortTestWith9Element() {
        int[] actual = {1, 5, 9, 4, 7, 3, 2, 8, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArraySortUtil.insertSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void insertSortTestWithRepeatableElements() {
        int[] actual = {1, 5, 9, 1, 4, 7, 3, 2, 8, 8, -6};
        int[] expected = {-6, 1, 1, 2, 3, 4, 5, 7, 8, 8, 9};
        ArraySortUtil.insertSort(actual);

        Assert.assertArrayEquals(expected, actual);
    }
}