package com.percyvega.experiments.generics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class MyHashMap extends HashMap {
    static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<>();
    }
}

@Log4j2
class CollectionsTest {

    private void addItems(boolean upperCase, HashMap<Integer, String> numbers) {
        numbers.put(0, upperCase ? "Zero".toUpperCase() : "Zero".toLowerCase());
        numbers.put(1, upperCase ? "One".toUpperCase() : "One".toLowerCase());
        numbers.put(2, upperCase ? "Two".toUpperCase() : "Two".toLowerCase());
        numbers.put(3, upperCase ? "Three".toUpperCase() : "Three".toLowerCase());
    }

    @Test
    void collection_instantiation_without_generics() {
        HashMap<Integer, String> numbers = new HashMap<>();

        addItems(true, numbers);

        assertThat(numbers).containsEntry(3, "THREE");
        assertThat(numbers).doesNotContainValue("three");
    }

    @Test
    void collection_factory_with_generics() {
        HashMap<Integer, String> numbers = MyHashMap.newInstance();

        addItems(false, numbers);

        assertThat(numbers).containsEntry(3, "three");
        assertThat(numbers).doesNotContainValue("THREE");
    }

}