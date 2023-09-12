package com.percyvega.experiments.java8.streams.terminal;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SummingIntAndAveragingIntTest {

    @Test
    void sum_without_collect() {
        int sum = StudentsListSupplier.get().stream()
                .mapToInt(Student::getNoteBooks)
                .sum();

        assertThat(sum).isEqualTo(189);
    }

    @Test
    void summingInt() {
        Integer summingInt = StudentsListSupplier.get().stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));

        assertThat(summingInt).isEqualTo(189);
    }

    @Test
    void average_without_collect() {
        OptionalDouble optionalDouble = StudentsListSupplier.get().stream()
                .mapToDouble(Student::getGpa)
                .average();

        assertThat(optionalDouble.getAsDouble()).isEqualTo(3.586, Offset.offset(.001));
    }

    @Test
    void averagingDouble() {
        Double collect = StudentsListSupplier.get().stream()
                .collect(Collectors.averagingDouble(Student::getGpa));

        assertThat(collect).isEqualTo(3.586, Offset.offset(.001));
    }

}
