package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.percyvega.experiments.collections.BibleReference.*;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MapTests {

    @Test
    public void map_elements() {
        addElementsAndPrint(new HashMap<>());
        addElementsAndPrint(new LinkedHashMap<>()); // guarantees order of insertion is kept
        addElementsAndPrint(new TreeMap<>()); // sorted by key
        addElementsAndPrint(new Hashtable<>());
    }

    private void addElementsAndPrint(Map<BibleReference, BibleReference> map) {
        map.put(GENESIS_1_1, GENESIS_1_1);
        map.put(EXODUS_1_1, EXODUS_1_1);
        map.put(LEVITICUS_1_1, LEVITICUS_1_1);
        map.put(NUMBERS_1_1, NUMBERS_1_1);
        map.put(DEUTERONOMY_1_1, DEUTERONOMY_1_1);
        map.put(REVELATION_1_1, REVELATION_1_1);
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
            log.info("Key: " + key + ", Value: " + value);
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
                        (map, e) -> map.put(e, e),
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

    @Test
    public void hashtable_operations() {
        Map<String, BibleReference> hashtable = new Hashtable<>();
        hashtable.put(GENESIS_1_1.getBook(), GENESIS_1_1);
        hashtable.put(EXODUS_1_1.getBook(), EXODUS_1_1);
        hashtable.put(LEVITICUS_1_1.getBook(), LEVITICUS_1_1);
        hashtable.put(NUMBERS_1_1.getBook(), NUMBERS_1_1);
        hashtable.put(DEUTERONOMY_1_1.getBook(), DEUTERONOMY_1_1);
        hashtable.put(REVELATION_1_1.getBook(), REVELATION_1_1);
        hashtable.put(REVELATION_22_21.getBook(), REVELATION_22_21);

        log.info(hashtable.get(DEUTERONOMY_1_1.getBook()));
        log.info(hashtable.remove(DEUTERONOMY_1_1.getBook()));

        hashtable.forEach((k, v) -> log.info("Key: {} and Value: {}", k, v));
    }

    @Test
    public void test_hashtable_with_string_key() {
        Map<String, BibleReference> hashtable = new Hashtable<>();
        hashtable.put(GENESIS_1_1.getBook(), GENESIS_1_1);
        hashtable.put(EXODUS_1_1.getBook(), EXODUS_1_1);
        hashtable.put(LEVITICUS_1_1.getBook(), LEVITICUS_1_1);
        hashtable.put(NUMBERS_1_1.getBook(), NUMBERS_1_1);
        hashtable.put(DEUTERONOMY_1_1.getBook(), DEUTERONOMY_1_1);
        hashtable.put(REVELATION_1_1.getBook(), REVELATION_1_1);
        hashtable.put(REVELATION_22_21.getBook(), REVELATION_22_21);

        System.out.println();

        log.info("Size: {}", hashtable.size());

        System.out.println();

        hashtable.forEach((k, v) -> log.info("Key: {} and Value: {}", k, v));

        System.out.println();

        log.info(((Hashtable<String, BibleReference>) hashtable).contains(REVELATION_1_1));

        System.out.println();

        log.info(((Hashtable<String, BibleReference>) hashtable).contains(REVELATION_22_21));
    }

    @Test
    public void test_hashtable_with_bibleReference_key() {
        Map<BibleReference, BibleReference> hashtable = new Hashtable<>();
        hashtable.put(GENESIS_1_1, GENESIS_1_1);
        hashtable.put(EXODUS_1_1, EXODUS_1_1);
        hashtable.put(LEVITICUS_1_1, LEVITICUS_1_1);
        hashtable.put(NUMBERS_1_1, NUMBERS_1_1);
        hashtable.put(DEUTERONOMY_1_1, DEUTERONOMY_1_1);
        hashtable.put(REVELATION_1_1, REVELATION_1_1);
        hashtable.put(REVELATION_22_21, REVELATION_22_21);

        System.out.println();

        log.info("Size: {}", hashtable.size());

        System.out.println();

        hashtable.forEach((k, v) -> log.info("Key: {} and Value: {}", k, v));

        System.out.println();

        log.info(((Hashtable<BibleReference, BibleReference>) hashtable).contains(REVELATION_1_1));

        System.out.println();

        log.info(((Hashtable<BibleReference, BibleReference>) hashtable).contains(REVELATION_22_21));
    }

    @Test
    public void test_hashtable_with_bibleReferences() {
        Map<BibleReference, BibleReference> hashtable = Arrays
                .stream(BibleReferences.getAll())
                .collect(Hashtable::new,
                        (map, e) -> map.put(e, e),
                        Hashtable::putAll);

        log.info("Size: {}", hashtable.size());

        System.out.println();

        log.info(((Hashtable<BibleReference, BibleReference>) hashtable).contains(REVELATION_1_1));

        System.out.println();

        log.info(((Hashtable<BibleReference, BibleReference>) hashtable).contains(REVELATION_22_21));
    }

}
