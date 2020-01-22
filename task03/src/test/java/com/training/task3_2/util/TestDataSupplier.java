package com.training.task3_2.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataSupplier {
    private static final StudentEntity[] STUDENTS_1 = {
            new StudentEntity("Vasya", 34, 200),
            new StudentEntity("Masha", 10, 150),
            new StudentEntity("Petya", 9, 170)};

    private static final StudentEntity[] STUDENTS_2 = {
            new StudentEntity("Vasya", 20, 200),
            new StudentEntity("Masha", 10, 170),
            new StudentEntity("Petya", 9, 170)};

    private static final StudentEntity[] STUDENTS_3 = {
            new StudentEntity("Vasya", 34, 200),
            new StudentEntity("Masha", 10, 150),
            new StudentEntity("Petya", 10, 150)};

    private static final StudentEntity[] STUDENTS_4 = {
            new StudentEntity("Vasya", 34, 200),
            new StudentEntity("Masha", 10, 180),
            new StudentEntity("Petya", 10, 150)};

    private static final StudentEntity[] EXPECTED_STUDENTS_1 = {
            new StudentEntity("Masha", 10, 150),
            new StudentEntity("Petya", 9, 170),
            new StudentEntity("Vasya", 34, 200)};

    private static final StudentEntity[] EXPECTED_STUDENTS_2 = {
            new StudentEntity("Petya", 9, 170),
            new StudentEntity("Masha", 10, 170),
            new StudentEntity("Vasya", 20, 200),};

    private static final StudentEntity[] EXPECTED_STUDENTS_3 = {
            new StudentEntity("Masha", 10, 150),
            new StudentEntity("Petya", 10, 150),
            new StudentEntity("Vasya", 34, 200)};

    private static final StudentEntity[] EXPECTED_STUDENTS_4 = {
            new StudentEntity("Petya", 10, 150),
            new StudentEntity("Masha", 10, 180),
            new StudentEntity("Vasya", 34, 200)};


    private static final StudentEntity[] EXPECTED_AGE_COMPARATOR_STUDENTS_1 = {
            new StudentEntity("Petya", 9, 170),
            new StudentEntity("Masha", 10, 150),
            new StudentEntity("Vasya", 34, 200)};

    private static final StudentEntity[] EXPECTED_AGE_COMPARATOR_STUDENTS_2 = {
            new StudentEntity("Petya", 9, 170),
            new StudentEntity("Masha", 10, 170),
            new StudentEntity("Vasya", 20, 200),};

    private static final StudentEntity[] EXPECTED_AGE_COMPARATOR_STUDENTS_3 = {
            new StudentEntity("Masha", 10, 150),
            new StudentEntity("Petya", 10, 150),
            new StudentEntity("Vasya", 34, 200)};

    private static final StudentEntity[] EXPECTED_AGE_COMPARATOR_STUDENTS_4 = {
            new StudentEntity("Petya", 10, 150),
            new StudentEntity("Masha", 10, 180),
            new StudentEntity("Vasya", 34, 200)};

    public static List<StudentEntity[]> getSourceArray() {
        return new ArrayList<>(Arrays.asList(STUDENTS_1,
                STUDENTS_2,
                STUDENTS_3,
                STUDENTS_4));
    }

    public static List<StudentEntity[]> getExpectedArray() {
        return new ArrayList<>(Arrays.asList(EXPECTED_STUDENTS_1,
                EXPECTED_STUDENTS_2,
                EXPECTED_STUDENTS_3,
                EXPECTED_STUDENTS_4));
    }

    public static List<StudentEntity[]> getExpectedWithAgeComparatorArray() {
        return new ArrayList<>(Arrays.asList(EXPECTED_AGE_COMPARATOR_STUDENTS_1,
                EXPECTED_AGE_COMPARATOR_STUDENTS_2,
                EXPECTED_AGE_COMPARATOR_STUDENTS_3,
                EXPECTED_AGE_COMPARATOR_STUDENTS_4));
    }
}