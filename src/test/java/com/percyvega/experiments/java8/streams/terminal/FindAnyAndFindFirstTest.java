package com.percyvega.experiments.java8.streams.terminal;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class FindAnyAndFindFirstTest {

    @Test
    void findAny() {
        Optional<Student> optionalStudent = StudentsListSupplier.get().stream()
                .filter(student -> student.getNoteBooks() >= 23)
                .findAny();
        assertThat(optionalStudent).isEmpty();
    }

    @Test
    void findFirst() {
        Optional<Student> optionalStudent = StudentsListSupplier.get().stream()
                .filter(student -> student.getGpa() == 4.0)
                .findFirst();
        assertThat(optionalStudent.get().getName()).isEqualTo("Emma Thompson");
    }

    @Test
    void findFirst2() {
        Stream.of("Percy", "Fran", "Nico", "Isabella")
                .sorted()
                .findFirst()
                .ifPresent(log::info);
    }

}
