package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SetTests {

    private static final BibleReference GENESIS_1_1 = new BibleReference("Genesis", 1, 1);
    private static final BibleReference EXODUS_1_1 = new BibleReference("Exodus", 1, 1);
    private static final BibleReference LEVITICUS_1_1 = new BibleReference("Leviticus", 1, 1);
    private static final BibleReference NUMBERS_1_1 = new BibleReference("Numbers", 1, 1);
    private static final BibleReference DEUTERONOMY_1_1 = new BibleReference("Deuteronomy", 1, 1);
    private static final BibleReference REVELATION_22_21 = new BibleReference("Revelation", 22, 21);

    @Test
    public void set_elements() {
        addElementsAndPrint(new HashSet<>());
        addElementsAndPrint(new LinkedHashSet<>());
        addElementsAndPrint(new TreeSet<>());
    }

    private void addElementsAndPrint(Set<BibleReference> set) {
        set.add(GENESIS_1_1);
        set.add(EXODUS_1_1);
        set.add(LEVITICUS_1_1);
        set.add(NUMBERS_1_1);
        set.add(DEUTERONOMY_1_1);
        set.add(REVELATION_22_21);

        log.info("{} Printing {} {}", "***********", set.getClass().getSimpleName(), "***********");
        set.forEach((e) -> log.info(e.getFullName()));
    }

    @Test
    public void set_operations() {
        Set<Integer> ages = new HashSet<>();
        ages.add(34); // {34}
        ages.addAll(Arrays.asList(34, 2, 7, 52, 23)); // {34, 2, 7, 52, 23}
        ages.removeAll(Arrays.asList(34, 52)); // {2, 7, 23}
        ages.retainAll(Arrays.asList(1, 2, 23)); // {2, 23}
        ages.forEach(log::info);

        Set<String> lastNames = new HashSet<>(Arrays.asList("Vega", "Castillo", "Bobadilla", "Ponze"));
        lastNames.forEach(log::info);
    }

    @Test
    public void test_hashSet_is_unordered() {
        Set<String> booksHashSet = Arrays
                .stream(BibleReferences.getAll())
                .map(BibleReference::getBook)
                .collect(Collectors.toCollection(HashSet::new));

        booksHashSet.forEach(log::info);

        assertThat(booksHashSet.size()).isEqualTo(BibleCounter.getBookCount());
    }

    @Test
    public void test_hashSet_find() {
        Set<String> fullNamesHashSet = Arrays
                .stream(BibleReferences.getAll())
                .map(BibleReference::getFullName)
                .collect(Collectors.toCollection(HashSet::new));

        assertThat(fullNamesHashSet.size()).isEqualTo(BibleCounter.getTotalVerseCount());

        LocalTime started = LocalTime.now();
        assertThat(fullNamesHashSet.contains(REVELATION_22_21.getFullName())).isTrue();
        LocalTime finished = LocalTime.now();
        log.info("hashset.contains finished in {} nanoseconds", ChronoUnit.NANOS.between(started, finished));
    }

    @Test
    public void test_hashSet_find_myClass() {
        Set<BibleReference> hashSet = Arrays
                .stream(BibleReferences.getAll())
                .collect(Collectors.toCollection(HashSet::new));

        assertThat(hashSet.size()).isEqualTo(BibleCounter.getTotalVerseCount());

        LocalTime started = LocalTime.now();
        assertThat(hashSet.contains(REVELATION_22_21)).isTrue();
        LocalTime finished = LocalTime.now();
        log.info("hashset.contains finished in {} nanoseconds", ChronoUnit.NANOS.between(started, finished));
    }

    @Test
    public void test_linkedHashSet_is_ordered() {
        Set<String> booksLinkedHashSet = Arrays
                .stream(BibleReferences.getAll())
                .map(BibleReference::getBook)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        booksLinkedHashSet.forEach(log::info);

        assertThat(booksLinkedHashSet.toArray()[0]).isEqualTo(BibleCounter.bookNames[0]);
    }

    @Test
    public void test_linkedHashSet_adding_an_existing_element_does_not_change_its_location() {
        Set<String> booksLinkedHashSet = Arrays
                .stream(BibleReferences.getAll())
                .map(BibleReference::getBook)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        booksLinkedHashSet.forEach(log::info);

        assertThat(booksLinkedHashSet.size()).isEqualTo(BibleCounter.getBookCount());

        Object[] booksBeforeInsertion = booksLinkedHashSet.toArray();
        booksLinkedHashSet.add(BibleCounter.bookNames[1]); // Exodus
        Object[] booksAfterInsertion = booksLinkedHashSet.toArray();

        assertThat(booksBeforeInsertion).isEqualTo(booksAfterInsertion);
    }

    @Test
    public void test_linkedHashSet_find() {
        Set<String> fullNamesLinkedHashSet = Arrays
                .stream(BibleReferences.getAll())
                .map(BibleReference::getFullName)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        assertThat(fullNamesLinkedHashSet.size()).isEqualTo(BibleCounter.getTotalVerseCount());

        LocalTime started = LocalTime.now();
        assertThat(fullNamesLinkedHashSet.contains(REVELATION_22_21.getFullName())).isTrue();
        LocalTime finished = LocalTime.now();
        log.info("linkedhashset.contains finished in {} nanoseconds", ChronoUnit.NANOS.between(started, finished));
    }

    @Test
    public void test_linkedHashSet_find_myClass() {
        Set<BibleReference> linkedHashSet = Arrays
                .stream(BibleReferences.getAll())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        assertThat(linkedHashSet.size()).isEqualTo(BibleCounter.getTotalVerseCount());

        LocalTime started = LocalTime.now();
        assertThat(linkedHashSet.contains(REVELATION_22_21)).isTrue();
        LocalTime finished = LocalTime.now();
        log.info("linkedhashset.contains finished in {} nanoseconds", ChronoUnit.NANOS.between(started, finished));
    }

    @Test
    public void test_treeSet_is_sorted() {
        Set<String> booksHashSet = Arrays
                .stream(BibleReferences.getAll())
                .map(BibleReference::getBook)
                .collect(Collectors.toCollection(HashSet::new));
        Set<String> booksTreeSet = new TreeSet<>(booksHashSet);

        booksTreeSet.forEach(log::info);

        assertThat(booksTreeSet.toArray()[booksTreeSet.size() - 1]).isEqualTo("Zephaniah");
    }

    @Test
    public void test_treeSet_find() {
        Set<String> fullNamesHashSet = Arrays
                .stream(BibleReferences.getAll())
                .map(BibleReference::getFullName)
                .collect(Collectors.toCollection(HashSet::new));
        Set<String> fullNamesTreeSet = new TreeSet<>(fullNamesHashSet);

        LocalTime started = LocalTime.now();
        assertThat(fullNamesTreeSet.contains(REVELATION_22_21.getFullName())).isTrue();
        LocalTime finished = LocalTime.now();
        log.info("treeset.contains finished in {} nanoseconds", ChronoUnit.NANOS.between(started, finished));
    }
    @Test
    public void test_treeSet_find_myClass() {
        Set<BibleReference> hashSet = Arrays
                .stream(BibleReferences.getAll())
                .collect(Collectors.toCollection(HashSet::new));
        Set<BibleReference> treeSet = new TreeSet<>(hashSet);

        LocalTime started = LocalTime.now();
        assertThat(treeSet.contains(REVELATION_22_21)).isTrue();
        LocalTime finished = LocalTime.now();
        log.info("treeset.contains finished in {} nanoseconds", ChronoUnit.NANOS.between(started, finished));

        treeSet.forEach(log::info);
    }
}
