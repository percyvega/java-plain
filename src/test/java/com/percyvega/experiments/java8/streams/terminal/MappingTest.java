package com.percyvega.experiments.java8.streams.terminal;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MappingTest {

    @Test
    void toList_without_collect_mapping() {
        List<String> collect = StudentsListSupplier.get().stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        assertThat(collect.size()).isEqualTo(15);
    }

    @Test
    void toList_with_collect_mapping() {
        List<String> collect = StudentsListSupplier.get().stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));

        assertThat(collect.size()).isEqualTo(15);
    }

    @Test
    void toSet_without_collect_mapping() {
        Set<String> collect = StudentsListSupplier.get().stream()
                .map(Student::getName)
                .collect(Collectors.toSet());

        assertThat(collect.size()).isEqualTo(15);
    }

    @Test
    void toSet_with_collect_mapping() {
        Set<String> collect = StudentsListSupplier.get().stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));

        assertThat(collect.size()).isEqualTo(15);
    }

}
