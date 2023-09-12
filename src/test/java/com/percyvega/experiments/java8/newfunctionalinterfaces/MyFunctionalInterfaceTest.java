package com.percyvega.experiments.java8.newfunctionalinterfaces;

import org.junit.jupiter.api.Test;

public class MyFunctionalInterfaceTest {
    @Test
    void myFunctionalInterface1() {
        MyFunctionalInterface sum = (s1, s2, s3) ->  Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
        System.out.println(sum.sum("11", "33", "55") / 1.0);
    }

    @Test
    void myFunctionalInterface2() {
        MyFunctionalInterface charCount = (s1, s2, s3) -> s1.concat(s2).concat(s3).length();
        System.out.println(charCount.sum("1", "33", "555"));
    }

    @FunctionalInterface
    interface MyFunctionalInterface {
        int sum(String s1, String s2, String s3);
    }

}
