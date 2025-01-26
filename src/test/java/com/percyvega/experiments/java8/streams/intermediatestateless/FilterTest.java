package com.percyvega.experiments.java8.streams.intermediatestateless;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.percyvega.experiments.java8.model.Constants.MALE;

@Log4j2
public class FilterTest {

    @Test
    void test_filter() {
        Map<String, List<String>> studentNameAndActivities = StudentsListSupplier.get().stream()
                .filter(student -> student.getGradeLevel() >= 3)
                .filter(student -> student.getGpa() >= 3.5)
                .filter(student -> MALE.equals(student.getGender()))
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        studentNameAndActivities.forEach((name, activities) -> log.info(name + ": " + activities));
    }

    @Test
    void testStreamOf() {
        Stream.of("apple", "pear", "banana", "cherry", "apricot")
                .filter(f -> f.startsWith("a"))
                .forEach(f -> log.info("Starts with an 'a': " + f));
    }

}
