package com.javacourse.task1_1.utility;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.javacourse.task1_1.utility.CollectionUtility.nullSafeListInitialize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollectionUtilityTest {

    @Test
    public void nullSafeListInitializeShouldReturnEmptyListIfInputNull() {
        final List<Object> actual = nullSafeListInitialize(null);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void nullSafeListInitializeShouldReturnListIfInputIsNotNull() {
        List<Integer> items = Arrays.asList(1, 2, 3);
        final List<Integer> actual = nullSafeListInitialize(items);

        assertFalse(actual.isEmpty());
        assertEquals(3, actual.size());
    }

}