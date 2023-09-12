package com.percyvega.experiments.java8.newfunctionalinterfaces;

import org.junit.jupiter.api.Test;

import java.util.function.*;

public class OneOfEachTest {

    private static String THIS_IS_A_STRING = "This is a String";
    private static String IT_WORKS = "It works!";
    private static String FAVORITE_NUMBER = "23";

    @Test
    void consumerAccept() {
        Consumer<String> printUppercaseConsumer = s -> System.out.println(s.toUpperCase());
        printUppercaseConsumer.accept(THIS_IS_A_STRING);
    }

    @Test
    void supplierGet() {
        Supplier<String> s = () -> THIS_IS_A_STRING;
        System.out.println(s.get());
    }

    @Test
    void predicateTest() {
        Predicate<String> longerThan10Predicate = s -> s.length() > 10;
        System.out.println(longerThan10Predicate.test(THIS_IS_A_STRING));
        System.out.println(longerThan10Predicate.test(IT_WORKS));
    }

    @Test
    void functionApply() {
        Function<String, Integer> stringToIntegerFunction = Integer::parseInt; // s -> Integer.parseInt(s)
        System.out.println("My favorite number is " + stringToIntegerFunction.apply(FAVORITE_NUMBER) / 1.0);
    }

    @Test
    void biFunctionApply() {
        BiFunction<String, String, Integer> stringConcatThenToIntegerBiFunction = (s1, s2) -> Integer.parseInt(s1.concat(s2));
        System.out.println(stringConcatThenToIntegerBiFunction.apply(FAVORITE_NUMBER, FAVORITE_NUMBER) / 1.0);
    }

    @Test
    void binaryOperatorApply() {
        BinaryOperator<String> concatUppercaseBinaryFunction = (x, y) -> x.concat(", ").concat(y).toUpperCase();
        System.out.println(concatUppercaseBinaryFunction.apply(THIS_IS_A_STRING, IT_WORKS));
    }

    @Test
    void unaryOperatorApply() {
        UnaryOperator<String> duplicateUnaryOperator = s -> s.concat(", ").concat(s);
        System.out.println(duplicateUnaryOperator.apply(IT_WORKS));
    }

}
