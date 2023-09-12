package com.percyvega.experiments.java8.streams.terminal;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class CountingTest {

    @Test
    void count_without_collect() {
        long count = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();

        assertThat(count).isEqualTo(9);
    }

    @Test
    void counting() {
        Long counting = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.counting());

        assertThat(counting).isEqualTo(9L);
    }

}
