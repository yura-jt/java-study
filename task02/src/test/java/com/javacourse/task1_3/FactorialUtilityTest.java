package com.javacourse.task1_3;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FactorialUtilityTest {

    @Test
    public void customFactorialCalcShouldReturnValidResultForParam1() {
        String expected = FactorialUtility.customFactorialCalc(1);
        assertEquals(expected, "1");
    }

    @Test
    public void customFactorialCalcShouldReturnValidResultForParam10() {
        String expected = FactorialUtility.customFactorialCalc(10);
        assertEquals(expected, "3628800");
    }

    @Test
    public void customFactorialCalcShouldReturnValidResultForParam27() {
        String expected = FactorialUtility.customFactorialCalc(27);
        assertEquals(expected, "10888869450418352160768000000");
    }

    @Test
    public void customFactorialCalcShouldReturnValidResultForParam30() {
        String expected = FactorialUtility.customFactorialCalc(30);
        assertEquals(expected, "265252859812191058636308480000000");
    }

    @Test
    public void bigIntegerFactorialCalcShouldReturnValidResultForParam1() {
        BigInteger expected = FactorialUtility.bigIntegerFactorialCalc(1);
        assertEquals(expected, BigInteger.ONE);
    }

    @Test
    public void bigIntegerFactorialCalcShouldReturnValidResultForParam10() {
        BigInteger expected = FactorialUtility.bigIntegerFactorialCalc(10);
        assertEquals(expected, new BigInteger("3628800"));
    }

    @Test
    public void bigIntegerFactorialCalcShouldReturnValidResultForParam27() {
        BigInteger expected = FactorialUtility.bigIntegerFactorialCalc(27);
        assertEquals(expected, new BigInteger("10888869450418352160768000000"));
    }

    @Test
    public void bigIntegerFactorialCalcShouldReturnValidResultForParam30() {
        BigInteger expected = FactorialUtility.bigIntegerFactorialCalc(30);
        assertEquals(expected, new BigInteger("265252859812191058636308480000000"));
    }
}