package com.training.task3_2;

import com.training.task3_2.util.SortByAgeComparator;
import com.training.task3_2.util.StudentEntity;
import com.training.task3_2.util.TestDataSupplier;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ObjectSortUtilTest {
    private List<StudentEntity[]> source;
    private List<StudentEntity[]> expected;
    private List<StudentEntity[]> expectedWithComparator;
    private Comparator<StudentEntity> comparator;

    @Before
    public void init() {
        source = TestDataSupplier.getSourceArray();
        expected = TestDataSupplier.getExpectedArray();
        expectedWithComparator = TestDataSupplier.getExpectedWithAgeComparatorArray();
        comparator = new SortByAgeComparator();
    }

    @Test
    public void shouldVerifySort() {
       verifySort(source.get(0), expected.get(0));
       verifySort(source.get(1), expected.get(1));
       verifySort(source.get(2), expected.get(2));
       verifySort(source.get(3), expected.get(3));
    }

    @SuppressWarnings("unchecked")
    private void verifySort(StudentEntity[] source, StudentEntity[] expected) {
        ObjectSortUtil.sort(source);
        assertArrayEquals(source, expected);
    }

    @Test
    public void shouldVerifySortWithComparator() {
        verifySortWithAgeComparator(source.get(0), expectedWithComparator.get(0), comparator);
        verifySortWithAgeComparator(source.get(1), expectedWithComparator.get(1), comparator);
        verifySortWithAgeComparator(source.get(2), expectedWithComparator.get(2), comparator);
        verifySortWithAgeComparator(source.get(3), expectedWithComparator.get(3), comparator);
    }

    @SuppressWarnings("unchecked")
    private void verifySortWithAgeComparator(StudentEntity[] source, StudentEntity[] expected, Comparator<StudentEntity> comparator) {
        ObjectSortUtil.sort(source, comparator);
        assertArrayEquals(source, expected);
    }
}