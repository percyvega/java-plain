package com.percyvega.experiments.generics;


import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

/*
    You can use anything, but these are the conventions:
        E - Element
        K - Key
        N - Number
        T - Type
        V - Value
        ? - unknown - where the type of objects are irrelevant (e.g. counting list elements)
 */

@Log4j2
public class AppGenericArrays {


    public static void main(String... args) {
        Integer[] integers = new Integer[]{4, 2, 10, 18, 10, 16, 36, 34};
        print(integers);
        printLargestNumber(integers);

        String[] strings = {"Matthew", "Mark", "Luke", "John"};
        print(strings);
//        printLargestNumber(strings);

        Integer[] integerArray = {1, 2, 3, 4, 5};
        print(integerArray);
        printLargestNumber(integerArray);

        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        print(doubleArray);
        printLargestNumber(doubleArray);

        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        print(charArray);
//        printLargestNumber(charArray);

        log.debug(getLargestNumber(integers).toString());
    }

    public static <AA> void print(AA[] elements) {
        log.debug("Array: " + Arrays.toString(elements));
        StringBuilder stringBuilder = new StringBuilder();
        for (AA element : elements) {
            stringBuilder.append(element.toString() + " ");
        }
        log.debug("Elements: " + stringBuilder.toString());
    }

    //  A super      Number: A or any of its superclasses
    //  A extends    Number: A or any type that extends Number
    //  A implements Number: A or any type that implements Number
    public static <A extends Number> void printLargestNumber(A[] elements) {
        A largestNumber = elements[0];

        for (A element : elements) {
            if (element.doubleValue() > largestNumber.doubleValue()) {
                largestNumber = element;
            }
        }

        log.debug("Largest: " + largestNumber.toString());
    }

    public static <A extends Number> A getLargestNumber(A[] elements) {
        A largestNumber = elements[0];

        for (A element : elements) {
            if (element.doubleValue() > largestNumber.doubleValue()) {
                largestNumber = element;
            }
        }

        return largestNumber;
    }

}