package com.percyvega.experiments.java8.streams.intermediatestateless;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MapTest {

    @Test
    void test_map_toList() {
        List<String> namesList = StudentsListSupplier.get().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertThat(namesList).hasSize(15);
    }

    @Test
    void test_mapToDouble_toSet() {
        Set<Double> gpaSet1 = StudentsListSupplier.get().stream()
                .mapToDouble(Student::getGpa)
                .boxed()
                .collect(Collectors.toSet());

        Set<Double> gpaSet2 = StudentsListSupplier.get().stream()
                .map(Student::getGpa)
                .collect(Collectors.toSet());

        assertThat(gpaSet1).isEqualTo(gpaSet2);
    }

    @Test
    void test_mapToInt_sum() {
        int noteBooksCount = StudentsListSupplier.get().stream()
                .mapToInt(Student::getNoteBooks)
                .sum();

        assertThat(noteBooksCount).isEqualTo(189);
    }

    @Test
    void test_mapToInt_plusOne_sum() {
        int noteBooksCount = StudentsListSupplier.get().stream()
                .mapToInt(Student::getNoteBooks)
                .map(value -> value + 1)
                .sum();

        assertThat(noteBooksCount).isEqualTo(204);
    }

    @Test
    void test_mapToInt_average() {
        OptionalDouble average = StudentsListSupplier.get().stream()
                .mapToInt(Student::getGradeLevel)
                .average();

        average.ifPresent(log::info);
    }

}
