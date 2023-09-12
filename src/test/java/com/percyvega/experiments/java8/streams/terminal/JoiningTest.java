package com.percyvega.experiments.java8.streams.terminal;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class JoiningTest {

    @Test
    void joining() {
        String joined = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.joining());

        assertThat(joined).isEqualTo("aerobicsbaseballbasketballdancingfootballgymnasticssoccerswimmingvolleyball");
    }

    @Test
    void joining_with_a_delimeter() {
        String joined = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        assertThat(joined).isEqualTo("aerobics, baseball, basketball, dancing, football, gymnastics, soccer, swimming, volleyball");
    }

    @Test
    void joining_with_delimeters() {
        String joined = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", ", "All activities: ", "."));

        assertThat(joined).isEqualTo("All activities: aerobics, baseball, basketball, dancing, football, gymnastics, soccer, swimming, volleyball.");
    }

}
