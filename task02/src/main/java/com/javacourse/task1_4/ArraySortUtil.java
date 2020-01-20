package com.javacourse.task1_4;

import java.util.Arrays;

public class ArraySortUtil {
    public static void bubbleSort(int[] arr) {
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (arr[index + 1] < arr[index]) {
                    int tmp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            int minvalue = arr[barrier];
            int minvalueindex = barrier;
            for (int index = barrier + 1; index < arr.length; index++) {
                if (minvalue > arr[index]) {
                    minvalue = arr[index];
                    minvalueindex = index;
                }
            }
            if (arr[barrier] > minvalue) {
                int tmp = arr[minvalueindex];
                arr[minvalueindex] = arr[barrier];
                arr[barrier] = tmp;
            }
        }
    }

    public static void insertSort(int[] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            int newElement = arr[i];
            index = Arrays.binarySearch(arr, 0, i, arr[i]);
            if (index < 0) {
                index = -(index) - 1;
            }

            System.arraycopy(arr, index, arr, index + 1, i - index);
            arr[index] = newElement;
        }
    }
}