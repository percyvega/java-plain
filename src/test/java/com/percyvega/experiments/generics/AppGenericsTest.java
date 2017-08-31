package com.percyvega.experiments.generics;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.percyvega.experiments.hamcrest.IsPalindromicInteger.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AppGenericsTest {

    @Test
    public void collection_factory_without_generics() {
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(0, "zero");
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }

    @Test
    public void collection_factory_with_generics() {
        Map<Integer, String> numbers = MyHashMap.newInstance();
        numbers.put(0, "zero");
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }

}