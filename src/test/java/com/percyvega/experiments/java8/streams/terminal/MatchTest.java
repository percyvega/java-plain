package com.percyvega.experiments.java8.streams.terminal;

import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MatchTest {

    @Test
    void allMatch() {
        boolean allMatch = StudentsListSupplier.get().stream()
                .allMatch(student -> student.getNoteBooks() >= 10);
        assertThat(allMatch).isTrue();
    }

    @Test
    void anyMatch() {
        boolean anyMatch = StudentsListSupplier.get().stream()
                .anyMatch(student -> student.getGpa() == 4.0);
        assertThat(anyMatch).isTrue();
    }

    @Test
    void noneMatch() {
        boolean noneMatch = StudentsListSupplier.get().stream()
                .noneMatch(student -> student.getName().length() < 9);
        assertThat(noneMatch).isTrue();
    }

}
