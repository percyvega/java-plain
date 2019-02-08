package com.percyvega.experiments.autoboxing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
    Autoboxing: automatically converting a primitive (e.g. int) to its corresponding object wrapper (e.g. Integer)
    Unboxing: e.g. Integer to int
 */
public class AppAutoboxing {

    private final static Logger logger = LoggerFactory.getLogger(AppAutoboxing.class);

    public static void main(String... args) {
        List<Integer> integers = autoboxingExample1();
        logger.debug(integers.toString());

        logger.debug(autoboxingExample2(integers).toString());
    }

    public static List<Integer> autoboxingExample1() {
        List<Integer> integers = new ArrayList<>();

        for (int i = 1; i < 50; i += 2) {
            int nextInt = new Random().nextInt(i);
//            integers.add(Integer.valueOf(nextInt));
//            autoboxing
            integers.add(nextInt);
        }

        return integers;
    }

    private static List<Integer> autoboxingExample2(List<Integer> evenAndOddIntegers) {
        List<Integer> evenIntegers = new ArrayList<>();

        for (Integer integer : evenAndOddIntegers) {
//            autoboxing
            if (integer % 2 == 0)
                evenIntegers.add(integer);
        }

        return evenIntegers;
    }

}
