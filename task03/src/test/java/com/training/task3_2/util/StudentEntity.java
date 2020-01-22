package com.training.task3_2.util;

import java.util.Objects;

public class StudentEntity implements Comparable {
    private String name;
    private int age;
    private int height;

    public StudentEntity(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Object o) {
        StudentEntity other = (StudentEntity) o;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return age == that.age &&
                height == that.height &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height);
    }
}