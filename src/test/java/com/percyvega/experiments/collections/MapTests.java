package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MapTests {

    private static final BibleReference GENESIS_1_1 = new BibleReference("Genesis", 1, 1);
    private static final BibleReference EXODUS_1_1 = new BibleReference("Exodus", 1, 1);
    private static final BibleReference LEVITICUS_1_1 = new BibleReference("Leviticus", 1, 1);
    private static final BibleReference NUMBERS_1_1 = new BibleReference("Numbers", 1, 1);
    private static final BibleReference DEUTERONOMY_1_1 = new BibleReference("Deuteronomy", 1, 1);
    private static final BibleReference REVELATION_22_21 = new BibleReference("Revelation", 22, 21);

    @Test
    public void map_elements() {
        addElementsAndPrint(new HashMap<>());
        addElementsAndPrint(new LinkedHashMap<>());
        addElementsAndPrint(new TreeMap<>());
    }

    private void addElementsAndPrint(Map<BibleReference, BibleReference> map) {
        map.put(GENESIS_1_1, GENESIS_1_1);
        map.put(EXODUS_1_1, EXODUS_1_1);
        map.put(LEVITICUS_1_1, LEVITICUS_1_1);
        map.put(NUMBERS_1_1, NUMBERS_1_1);
        map.put(DEUTERONOMY_1_1, DEUTERONOMY_1_1);
        map.put(REVELATION_22_21, REVELATION_22_21);

        log.info("{} Printing {} {}", "***********", map.getClass().getSimpleName(), "***********");
        map.forEach((k, v) -> log.info(k.getFullName()));
    }

    @Test
    public void map_operations() {
        Map<String, List<String>> dictionary = new HashMap<>();

        List<String> javaLexicon = new ArrayList<>();
        javaLexicon.add("coffee");
        javaLexicon.add("programming language");

        List<String> liveLexicon = new ArrayList<>();
        liveLexicon.add("in person");
        liveLexicon.add("alive");

        dictionary.put("java", javaLexicon);
        dictionary.put("live", liveLexicon);

        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            log.debug("Key: " + key + ", Value: " + value);
        }
    }

    @Test
    public void test_hashMap_is_unordered() {
        Map<String, String> bookReference = Arrays
                .stream(BibleCounter.bookNames)
                .collect(Collectors.toMap(o -> o, o -> o));

        bookReference.forEach(log::info);
    }

    @Test
    public void test_linkedHashMap_is_ordered() {
        Map<String, String> bookReference = Arrays
                .stream(BibleCounter.bookNames)
                .collect(
                        LinkedHashMap::new,
                        (map, b) -> map.put(b, b),
                        Map::putAll);

        bookReference.forEach(log::info);

        assertThat(bookReference.values().toArray()[0]).isEqualTo(BibleCounter.bookNames[0]);
    }

    @Test
    public void test_treeMap_is_sorted() {
        Map<String, String> unordered = Arrays
                .stream(BibleCounter.bookNames)
                .collect(Collectors.toMap(o -> o, o -> o));

        Map<String, String> bookReference = unordered.entrySet()
                .stream()
                .collect((Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> newValue,
                        TreeMap::new)));

        bookReference.forEach(log::info);

        assertThat(bookReference.keySet().toArray()[bookReference.size() - 1]).isEqualTo("Zephaniah");
    }
}
