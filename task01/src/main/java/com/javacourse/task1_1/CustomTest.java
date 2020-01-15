package com.javacourse.task1_1;

import com.javacourse.task1_1.annotation.*;

public class CustomTest {
    @BeforeClass
    public void beforeClass1() {
        System.out.println("executing @BeforeClass method 1 code...");
    }

    @BeforeClass
    public void beforeClass2() {
        System.out.println("executing @BeforeClass method 2 code...\n");
    }

    @AfterClass
    public void afterClass1() {
        System.out.println("executing @AfterClass method 1 code...");
    }

    @AfterClass
    public void afterClass2() {
        System.out.println("executing @AfterClass method 2 code...");
    }

    @Before
    public void before1() {
        System.out.println("executing @Before method 1 code...");
    }

    @Before
    public void before2() {
        System.out.println("executing @Before method 2 code...");
    }

    @After
    public void after1() {
        System.out.println("executing @After method 1 code...");
    }

    @After
    public void after2() {
        System.out.println("executing @After method 2 code...\n");
    }

    @Test
    public void test1() {
        System.out.println("Performing Test #1");
    }

    @Test
    public void test2() {
        System.out.println("Performing Test #2");
    }

    @Test(expectedException = IllegalArgumentException.class)
    public void testException1() {
        System.out.println("Performing Test #3 with exception handling: should be matched");
        Character.toChars(-1);
    }

    @Test(expectedException = NumberFormatException.class)
    public void testException2() {
        System.out.println("Performing Test #4 with exception handling: should be matched");
        String s = "number";
        Integer.parseInt(s);
    }

    @Test(expectedException = IllegalArgumentException.class)
    public void testException3() {
        System.out.println("Performing Test #5 with exception handling: should not match");
        int a = 5 / 0;
    }

    @Test(expectedException = IllegalArgumentException.class, expectedMessage = "Wrong input")
    public void testException4() {
        System.out.println("Performing Test #5 with exception handling: should be matched");
        throw new IllegalArgumentException("Wrong input");
    }

    @Test(expectedException = NumberFormatException.class, expectedMessage = "expected message")
    public void testException5() {
        System.out.println("Performing Test #5 with exception handling: should not match");
        throw new NumberFormatException("actual message");
    }

    private void noTest() {
        System.out.println("Not a test. This text should not be appeared");
    }
}