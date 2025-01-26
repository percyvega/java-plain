package com.percyvega.experiments.java8.newfunctionalinterfaces;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Log4j2
public class OneOfEachTest {

    private static final String THIS_IS_A_STRING = "This is a String";
    private static final String IT_WORKS = "It works!";
    private static final String FAVORITE_NUMBER = "23";

    @Test
    void consumerAccept() {
        Consumer<String> printUppercaseConsumer = s -> log.info(s.toUpperCase());
        printUppercaseConsumer.accept(THIS_IS_A_STRING);
    }

    @Test
    void supplierGet() {
        Supplier<String> s = () -> THIS_IS_A_STRING;
        log.info(s.get());
    }

    @Test
    void predicateTest() {
        Predicate<String> longerThan10Predicate = s -> s.length() > 10;
        log.info(longerThan10Predicate.test(THIS_IS_A_STRING));
        log.info(longerThan10Predicate.test(IT_WORKS));
    }

    @Test
    void functionApply() {
        Function<String, Integer> stringToIntegerFunction = Integer::parseInt; // s -> Integer.parseInt(s)
        log.info("My favorite number is " + stringToIntegerFunction.apply(FAVORITE_NUMBER));
    }

    @Test
    void biFunctionApply() {
        BiFunction<String, String, Integer> stringConcatThenToIntegerBiFunction = (s1, s2) -> Integer.parseInt(s1.concat(s2));
        log.info(stringConcatThenToIntegerBiFunction.apply(FAVORITE_NUMBER, FAVORITE_NUMBER));
    }

    @Test
    void binaryOperatorApply() {
        BinaryOperator<String> concatUppercaseBinaryFunction = (x, y) -> x.concat(", ").concat(y).toUpperCase();
        log.info(concatUppercaseBinaryFunction.apply(THIS_IS_A_STRING, IT_WORKS));
    }

    @Test
    void unaryOperatorApply() {
        UnaryOperator<String> duplicateUnaryOperator = s -> s.concat(", ").concat(s);
        log.info(duplicateUnaryOperator.apply(IT_WORKS));
    }

}
