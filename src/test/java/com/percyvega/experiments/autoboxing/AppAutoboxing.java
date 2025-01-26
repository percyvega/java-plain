package com.percyvega.experiments.autoboxing;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
    Autoboxing: automatically converting a primitive (e.g. int) to its corresponding object wrapper (e.g. Integer)
    Unboxing: e.g. Integer to int
 */
@Log4j2
public class AppAutoboxing {


    public static void main(String... args) {
        List<Integer> integers = autoboxingExample1();
        log.info(integers.toString());

        log.info(autoboxingExample2(integers).toString());
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
