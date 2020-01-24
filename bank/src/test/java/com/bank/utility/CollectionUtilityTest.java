package com.bank.utility;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.bank.utility.CollectionUtility.nullSafeListInitialize;
import static org.junit.Assert.*;

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