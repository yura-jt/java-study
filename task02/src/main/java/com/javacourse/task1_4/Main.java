package com.javacourse.task1_4;

import java.util.Arrays;

public class Main {
    private static final int[] SOURCE_ARRAY = {1, 5, 9, 4, 7, 3, 2, 8, 6};

    public static void main(String[] args) {
        bubbleSortDemo();
        selectionSortDemo();
        insertSortDemo();
    }

    private static void bubbleSortDemo() {
        printSourceArray();
        int[] test = Arrays.copyOf(SOURCE_ARRAY, SOURCE_ARRAY.length);
        System.out.println("Sorted by bubbleSort method:");
        ArraySortUtil.bubbleSort(test);
        System.out.println(Arrays.toString(test));
    }

    private static void selectionSortDemo() {
        printSourceArray();
        int[] test = Arrays.copyOf(SOURCE_ARRAY, SOURCE_ARRAY.length);
        System.out.println("Sorted by selectionSort method:");
        ArraySortUtil.selectionSort(test);
        System.out.println(Arrays.toString(test));
    }

    private static void insertSortDemo() {
        printSourceArray();
        int[] test = Arrays.copyOf(SOURCE_ARRAY, SOURCE_ARRAY.length);
        System.out.println("Sorted by insertSort method:");
        ArraySortUtil.insertSort(test);
        System.out.println(Arrays.toString(test));
    }

    private static void printSourceArray() {
        System.out.println("\nSource array:");
        System.out.println(Arrays.toString(SOURCE_ARRAY));
    }
}