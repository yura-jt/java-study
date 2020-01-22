package com.training.task3_2;

import java.util.Comparator;
import java.util.stream.Stream;

public class ObjectSortUtil {
    static class Student implements Comparable {
        String name;
        int age;
        int height;

        public Student(String name, int age, int height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        @Override
        public int compareTo(Object o) {
            Student other = (Student) o;
            int heightDifference = this.height - other.height;
            if (heightDifference != 0) {
                return heightDifference;
            }
            int ageDifference = this.age - other.age;
            if (ageDifference != 0) {
                return ageDifference;
            }
            return this.name.compareTo(other.name);
        }
    }


    public static void main(String[] args) {
        Student student1 = new Student("Vasya", 5, 200);
        Student student2 = new Student("Masha", 10, 200);
        Student student3 = new Student("Petya", 9, 150);

        Student[] students = {student1, student2, student3};
        sort(new Student[0]);
        Comparator<Student> comparator = (o1, o2) -> {

            int ageDifference = o1.age - o2.age;
            if (ageDifference != 0) {
                return ageDifference;
            }

            int heightDifference = o1.height - o2.height;
            if (heightDifference != 0) {
                return heightDifference;
            }

            return o1.name.compareTo(o2.name);
        };
        sort(students, comparator);
        Stream.of(students).forEach(student -> System.out.println(student.name + " " + student.age + " " + student.height));
    }

    public static <T extends Comparable<? super T>> void sort(T[] array) {
        quickSort(array, 0, array.length - 1, null);
    }

    public static <T extends Comparable<? super T>> void sort(T[] array, Comparator<T> comparator) {
        quickSort(array, 0, array.length - 1, comparator);
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] array, int low, int high, Comparator<T> comparator) {
        if (comparator == null) {
            System.out.println("here");
            comparator = Comparator.naturalOrder();
        }

        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        T pivot = array[middle];

        int i = low;
        int j = high;

        while (i <= j) {
            while (comparator.compare(array[i], pivot) < 0) {
//            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (comparator.compare(array[j], pivot) > 0) {
//            while (array[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j, comparator);

        if (high > i)
            quickSort(array, i, high, comparator);
    }
}