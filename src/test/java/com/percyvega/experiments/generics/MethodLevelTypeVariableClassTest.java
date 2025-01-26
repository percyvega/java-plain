package com.percyvega.experiments.generics;

import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static com.percyvega.experiments.generics.MethodLevelTypeVariableClass.getDouble;
import static com.percyvega.experiments.generics.MethodLevelTypeVariableClass.getLargest;
import static com.percyvega.experiments.generics.MethodLevelTypeVariableClass.print;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class MethodLevelTypeVariableClass {

    static Pair<Integer, String> getDouble(Pair<Integer, String> integerStringPair) {
        return new Pair<>(integerStringPair.getT1() * 2, integerStringPair.getT2() + integerStringPair.getT2());
    }

    <T1, T2> Pair<T1, T2> getPair(T1 t1, T2 t2) {
        return new Pair<>(t1, t2);
    }

    static <AA> void print(AA[] elements) {
        log.info("Array: " + Arrays.toString(elements));
        StringBuilder stringBuilder = new StringBuilder();
        for (AA element : elements) {
            stringBuilder.append(element.toString());
            stringBuilder.append(" ");
        }
        log.info("Elements: " + stringBuilder);
    }

    //  A super      Number: A or any of its superclasses
    //  A extends    Number: A or any type that extends Number
    static <A extends Comparable<A>> A getLargest(A[] elements) {
        Arrays.sort(elements, Comparator.reverseOrder());

        return elements[0];
    }
}

@Value
class Pair<T1, T2> {
    private T1 t1;
    private T2 t2;
}

@Log4j2
class MethodLevelTypeVariableClassTest {

    @Test
    void getDoubleTest() {
        Pair<Integer, String> pair = new Pair<>(10, "Ten");
        assertThat(getDouble(pair)).isEqualTo(new Pair<>(20, "TenTen"));
    }

    @Test
    void getPairTest() {
        MethodLevelTypeVariableClass aClass = new MethodLevelTypeVariableClass();

        Integer i = 5;
        String s = "five";

        Pair<Integer, String> pair = aClass.getPair(i, s);
        log.info("T1 of type " + pair.getT1().getClass().getName() + " and value " + pair.getT1());
        log.info("T2 of type " + pair.getT2().getClass().getName() + " and value " + pair.getT2());
    }

    @Test
    void printArrayInts() {
        Integer[] integers = new Integer[]{4, 2, 10, 18, 10, 16, 36, 34};
        print(integers);

        assertThat(getLargest(integers)).isEqualTo(36);
    }

    @Test
    void printArrayIntegers() {
        Integer[] integerArray = {1, 2, 3, 4, 5};
        print(integerArray);

        assertThat(getLargest(integerArray)).isEqualTo(5);
    }

    @Test
    void printArrayDoubles() {
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        print(doubleArray);

        assertThat(getLargest(doubleArray)).isEqualTo(4.4);
    }

    @Test
    void printArrayChars() {
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        print(charArray);

        assertThat(getLargest(charArray)).isEqualTo('O');
    }

    @Test
    void printArrayStrings() {
        String[] strings = {"Matthew", "Mark", "Luke", "John"};
        print(strings);

        assertThat(getLargest(strings)).isEqualTo("Matthew");
    }

}
