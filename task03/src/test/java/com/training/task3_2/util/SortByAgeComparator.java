package com.training.task3_2.util;

import java.util.Comparator;

public class SortByAgeComparator implements Comparator<StudentEntity> {
    @Override
    public int compare(StudentEntity o1, StudentEntity o2) {
        int ageDifference = o1.getAge() - o2.getAge();
        if (ageDifference != 0) {
            return ageDifference;
        }

        int heightDifference = o1.getHeight() - o2.getHeight();
        if (heightDifference != 0) {
            return heightDifference;
        }

        return o1.getName().compareTo(o2.getName());
    }
}