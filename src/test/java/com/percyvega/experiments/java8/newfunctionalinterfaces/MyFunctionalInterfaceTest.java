package com.percyvega.experiments.java8.newfunctionalinterfaces;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class MyFunctionalInterfaceTest {
    @Test
    void myFunctionalInterface1() {
        MyFunctionalInterface sum = (s1, s2, s3) -> Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
        log.info(sum.sum("11", "33", "55"));
    }

    @Test
    void myFunctionalInterface2() {
        MyFunctionalInterface charCount = (s1, s2, s3) -> s1.concat(s2).concat(s3).length();
        log.info(charCount.sum("1", "33", "555"));
    }

    @FunctionalInterface
    interface MyFunctionalInterface {
        int sum(String s1, String s2, String s3);
    }

}
