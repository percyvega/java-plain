package com.percyvega.experiments.java8.streams.terminal;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MinByAndMaxByTest {

    @Test
    void min_without_collect() {
        Optional<Double> optionalDouble = StudentsListSupplier.get().stream()
                .map(Student::getGpa)
                .min(Double::compare);

        assertThat(optionalDouble.get()).isEqualTo(3d);
    }

    @Test
    void minBy() {
        Optional<Student> optionalStudent = StudentsListSupplier.get().stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));

        assertThat(optionalStudent.get().getName()).isEqualTo("Ben Affleck");
    }

    @Test
    void max_without_collect() {
        Optional<Integer> optionalInteger = StudentsListSupplier.get().stream()
                .map(Student::getNoteBooks)
                .max(Integer::compare);

        OptionalInt optionalInt = StudentsListSupplier.get().stream()
                .mapToInt(Student::getNoteBooks)
                .max();

        assertThat(optionalInteger.get()).isEqualTo(optionalInt.getAsInt());
        assertThat(optionalInteger.get()).isEqualTo(22);
    }

    @Test
    void maxBy() {
        Optional<Student> optionalStudent1 = StudentsListSupplier.get().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getNoteBooks)));

        Optional<Student> optionalStudent2 = StudentsListSupplier.get().stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Student::getNoteBooks)));

        assertThat(optionalStudent1).isEqualTo(optionalStudent2);
        assertThat(optionalStudent2.get().getNoteBooks()).isEqualTo(22);
    }

}
