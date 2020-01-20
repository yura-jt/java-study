package com.javacourse.task1_2;

//import sun.reflect.ConstructorAccessor;
//import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        deepReflectionTry();
        reflectFactoryExample();

        simpleTryWithDefaultReflectionApproach();
    }

    //due to moving sun.reflect library this method won't compile
    // on the jdk 9 and higher without environment setting changes
    public static void deepReflectionTry() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
/*        Class<SolarSystem> monsterClass = SolarSystem.class;
        Constructor<?> constructor = monsterClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);

        Field constructorAccessorField = Constructor.class.getDeclaredField("constructorAccessor");
        constructorAccessorField.setAccessible(true);
        ConstructorAccessor ca = (ConstructorAccessor) constructorAccessorField.get(constructor);
        if (ca == null) {
            Method acquireConstructorAccessorMethod = Constructor.class.getDeclaredMethod("acquireConstructorAccessor");
            acquireConstructorAccessorMethod.setAccessible(true);
            ca = (ConstructorAccessor) acquireConstructorAccessorMethod.invoke(constructor);
        }
        SolarSystem enumValue = (SolarSystem) ca.newInstance(new Object[]{"PLUTO", 9, "P", 0x2647});*/

//        Received output:
//        class com.javacourse.task1_2.SolarSystem was successfully instantiated
//        enum name: PLUTO
//        enum ordinal: 9
//        enum IAU code: P
//        enum unicode symbol: ♇
    }

    //due to moving sun.reflect library this method won't compile
    // on the jdk 9 and higher without environment setting changes

    public static void reflectFactoryExample() throws NoSuchMethodException, InvocationTargetException, InstantiationException {
/*        Constructor cstr = Language.class.getDeclaredConstructor(
                String.class, int.class
        );
        ReflectionFactory reflection =
                ReflectionFactory.getReflectionFactory();
        Language language = (Language)
                reflection.newConstructorAccessor(cstr).newInstance(new Object[]{"KLINGON", 1554});

        System.out.println(language.getClass() + " was instantiated");
        System.out.println("enum value is: " + language);
        System.out.println("enum ordinal is: " + language.ordinal());*/

//      Output received:
//        class com.javacourse.task1_2.Language was instantiated
//        enum value is: KLINGON
//        enum ordinal is: 1554
    }

    public static void simpleTryWithDefaultReflectionApproach() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Language> constructor;
        constructor = Language.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        Language language = constructor.newInstance("BABYLONIAN", 8);
    }
}