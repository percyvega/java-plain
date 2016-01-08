package com.percyvega.experiments.generics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/*
    You can use anything, but these are the conventions:
        E - Element
        K - Key
        N - Number
        T - Type
        V - Value
        ? - unknown - where the type of objects are irrelevant (e.g. counting list elements)
 */
public class AppGenerics {

    private final static Logger logger = LoggerFactory.getLogger(AppGenerics.class);

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

        List<Integer> list = Arrays.asList(integers);
        printCollection(list);
//        printCollectionOfObjects(list);
        printCollectionOfUnknowns(list);

        List list2 = Arrays.asList(integers);
        printCollectionOfObjects(list2);

        logger.debug(getLargestNumber(integers).toString());
    }

    public static <AA> void print(AA[] elements) {
        logger.debug("Array: " + Arrays.toString(elements));
        StringBuilder stringBuilder = new StringBuilder();
        for (AA element : elements) {
            stringBuilder.append(element.toString() + " ");
        }
        logger.debug("Elements: " + stringBuilder.toString());
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

        logger.debug("Largest: " + largestNumber.toString());
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

    public static void otherGenerics() {
        Set setOfRawType = new HashSet<String>();
        setOfRawType = new HashSet<Integer>();

        Set<Object> setOfAnyType = new HashSet<Object>();
        setOfAnyType.add("abc"); //legal
        setOfAnyType.add(new Float(3.0f));

        Set<?> setOfUnknownType = new LinkedHashSet<String>();
        setOfUnknownType = new LinkedHashSet<Integer>();

        Set<String> setOfString = new HashSet<String>(); //valid in Generics
        setOfString = new LinkedHashSet<String>(); // Ok

//        Set<Object> setOfObject = new HashSet<String>();

        Set<? extends Number> setOfAllSubTypeOfNumber = new HashSet<Integer>(); //legal - Integer extends Number
        setOfAllSubTypeOfNumber = new HashSet<Float>(); //legal - because Float extends Number

        Set<? super TreeMap> setOfAllSuperTypeOfTreeMap = new LinkedHashSet<TreeMap>(); //legal because TreeMap is superType of itself
        setOfAllSuperTypeOfTreeMap = new HashSet<SortedMap>(); //legal because SorteMap is super class of TreeMap
        setOfAllSuperTypeOfTreeMap = new LinkedHashSet<Map>(); //legal since Map is super type of TreeMap
    }

    public static void printCollection(Collection c) {
        Iterator i = c.iterator();
        for (int k = 0; k < c.size(); k++) {
            logger.debug(i.next().toString());
        }
    }

    public static void printCollectionOfObjects(Collection<Object> c) {
        for (Object e : c) {
            logger.debug(e.toString());
        }
    }

    public static void printCollectionOfUnknowns(Collection<?> c) {
        for (Object e : c) {
            logger.debug(e.toString());
        }
    }

}