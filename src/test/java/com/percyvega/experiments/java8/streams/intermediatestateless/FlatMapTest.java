package com.percyvega.experiments.java8.streams.intermediatestateless;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

@Log4j2
public class FlatMapTest {

    @Test
    void test_map_flatMap_toList() {
        List<String> activities = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        activities.forEach(log::info);
    }

    @Test
    void test_map_flatMap_distinct_toList() {
        List<String> activities = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        activities.forEach(log::info);
    }

    @Test
    void test_map_flatMap_distinct_sorted_toList() {
        List<String> activities = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        activities.forEach(log::info);
    }

    @Test
    void test_map_mapToLong_sum_distinct_count() {
        long beforeDistinctCount = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .mapToLong(List::size)
                .sum();

        long afterDistinctCount = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();

        log.info("Before distinct: {}", beforeDistinctCount);
        log.info("After distinct: {}", afterDistinctCount);
    }

    @Test
    void collectToList() {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        people.values().stream()
                .flatMap(Collection::stream)
                .sorted()
                .forEach(log::info);
    }

}
