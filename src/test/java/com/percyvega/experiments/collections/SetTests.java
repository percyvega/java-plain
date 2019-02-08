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
    public void test_hashSet() {
        Set<String> booksHashSet = Arrays.stream(BibleReferences.getAll()).map(BibleReference::getBook).collect(Collectors.toCollection(HashSet::new));

        booksHashSet.forEach(log::info);

        assertThat(booksHashSet.size()).isEqualTo(BibleInfo.getBookCount());
    }

    @Test
    public void test_hashSet_find() {
        Set<String> fullNamesHashSet = Arrays.stream(BibleReferences.getAll()).map(BibleReference::getFullName).collect(Collectors.toCollection(HashSet::new));

        assertThat(fullNamesHashSet.size()).isEqualTo(BibleInfo.getTotalVerseCount());

        LocalTime started = LocalTime.now();
        assertThat(fullNamesHashSet.contains("Ephesians 2:8")).isTrue();
        LocalTime finished = LocalTime.now();
        log.info("hashset.contains finished in {} nanoseconds", ChronoUnit.NANOS.between(started, finished));
    }

    @Test
    public void test_linkedHashSet_is_ordered() {
        Set<String> booksLinkedHashSet = Arrays.stream(BibleReferences.getAll()).map(BibleReference::getBook).collect(Collectors.toCollection(LinkedHashSet::new));

        booksLinkedHashSet.forEach(log::info);

        assertThat(booksLinkedHashSet.toArray()[0]).isEqualTo(BibleInfo.bookNames[0]);
    }

    @Test
    public void test_linkedHashSet_adding_an_existing_element_does_not_change_its_location() {
        Set<String> booksLinkedHashSet = Arrays.stream(BibleReferences.getAll()).map(BibleReference::getBook).collect(Collectors.toCollection(LinkedHashSet::new));

        booksLinkedHashSet.forEach(log::info);

        assertThat(booksLinkedHashSet.size()).isEqualTo(BibleInfo.getBookCount());

        Object[] booksBeforeInsertion = booksLinkedHashSet.toArray();
        booksLinkedHashSet.add(BibleInfo.bookNames[1]); // Exodus
        Object[] booksAfterInsertion = booksLinkedHashSet.toArray();

        assertThat(booksBeforeInsertion).isEqualTo(booksAfterInsertion);
    }

    @Test
    public void test_linkedHashSet_find() {
        Set<String> fullNamesLinkedHashSet = Arrays.stream(BibleReferences.getAll()).map(BibleReference::getFullName).collect(Collectors.toCollection(LinkedHashSet::new));

        assertThat(fullNamesLinkedHashSet.size()).isEqualTo(BibleInfo.getTotalVerseCount());

        LocalTime started = LocalTime.now();
        assertThat(fullNamesLinkedHashSet.contains("Ephesians 2:8")).isTrue();
        LocalTime finished = LocalTime.now();
        log.info("linkedhashset.contains finished in {} nanoseconds", ChronoUnit.NANOS.between(started, finished));
    }

    @Test
    public void test_treeSet_is_sorted() {
        Set<String> booksHashSet = Arrays.stream(BibleReferences.getAll()).map(BibleReference::getBook).collect(Collectors.toCollection(HashSet::new));
        Set<String> booksTreeSet = new TreeSet<>(booksHashSet);

        booksTreeSet.forEach(log::info);

        assertThat(booksTreeSet.toArray()[booksTreeSet.size() - 1]).isEqualTo("Zephaniah");
    }

    @Test
    public void test_treeSet_find() {
        Set<String> fullNamesHashSet = Arrays.stream(BibleReferences.getAll()).map(BibleReference::getFullName).collect(Collectors.toCollection(HashSet::new));
        Set<String> fullNamesTreeSet = new TreeSet<>(fullNamesHashSet);

        LocalTime started = LocalTime.now();
        assertThat(fullNamesTreeSet.contains("Ephesians 2:8")).isTrue();
        LocalTime finished = LocalTime.now();
        log.info("treeset.contains finished in {} nanoseconds", ChronoUnit.NANOS.between(started, finished));
    }
}
