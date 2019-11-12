package com.percyvega.experiments.reflection;

import java.lang.reflect.Field;

/**
 * Created by pevega on 1/22/2015.
 */
public class AppStrangeTotal {

    public static void main(String... args) throws Exception {
        Integer a = 1;
        process(a);

        Integer b = 1;
        Integer c = 2;
        System.out.println("b - c : " + (b - c)); // b - c : 1
    }

    private static void process(Integer a) throws NoSuchFieldException, IllegalAccessException {
        Field valField = a.getClass().getDeclaredField("value");
        valField.setAccessible(true);
        valField.setInt(a, 3);
    }
}
