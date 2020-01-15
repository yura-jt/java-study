package com.javacourse.task1_1;

import com.javacourse.task1_1.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public void run(Class<?> clazz) throws Exception {
        final Constructor<?> constructor = clazz.getConstructor();
        final Object object = constructor.newInstance();
        final Method[] methods = clazz.getDeclaredMethods();

        List<Method> testMethods = getMethodsByAnnotation(Test.class, methods);
        List<Method> beforeMethods = getMethodsByAnnotation(Before.class, methods);
        List<Method> afterMethods = getMethodsByAnnotation(After.class, methods);
        List<Method> beforeClassMethods = getMethodsByAnnotation(BeforeClass.class, methods);
        List<Method> afterClassMethods = getMethodsByAnnotation(AfterClass.class, methods);

        executeMethod(beforeClassMethods, object);
        for (Method testMethod : testMethods) {
            executeMethod(beforeMethods, object);
            try {
                Annotation annotation = testMethod.getAnnotation(Test.class);
                Test test = (Test) annotation;
                testMethod.invoke(object);
            } catch (Exception e) {
                Annotation annotation = testMethod.getAnnotation(Test.class);
                Test test = (Test) annotation;
                processExceptionMatching(e, test);
            }
            executeMethod(afterMethods, object);
        }
        executeMethod(afterClassMethods, object);
    }

    private void processExceptionMatching(Exception e, Test test) {
        String[] arr = e.getCause().toString().split(": ");
        String actualException = arr[0];
        String actualMessage = arr[1];
        String expectedException = test.expectedException().getName();
        String expectedMessage = test.expectedMessage();

        if (expectedMessage.equals("")) {
            expectedMessage = actualMessage;
        }

        if (actualException.equals(expectedException) && actualMessage.equals(expectedMessage)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    private void executeMethod(List<Method> methods, Object object) throws Exception {
        for (Method method : methods) {
            method.invoke(object);
        }
    }

    private List<Method> getMethodsByAnnotation(Class<? extends Annotation> annotation, Method[] methods) {
        final List<Method> tempMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotation)) {
                tempMethods.add(method);
            }
        }
        return tempMethods;
    }
}