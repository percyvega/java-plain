package com.percyvega.experiments.java8.interfaces;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class ComparatorTest {

    private static List<String> stringList = Arrays.asList("She", "It", "I", "He", "A", null, "Abstract", "Internationalization", "Four", "Seven");

    Comparator<String> comparatorComparingLength = Comparator.comparingInt(String::length);
    Comparator<String> comparatorNullsLastComparingLengthComparingHashcode = Comparator.nullsLast(Comparator.comparingInt(String::length).thenComparingInt(String::hashCode));
    Comparator<Student> comparatorComparingGpaComparingGradeReversed = Comparator.comparingDouble(Student::getGpa).thenComparingDouble(Student::getGradeLevel).reversed();

    @Test
    void listSort() {
        stringList.sort(Comparator.nullsFirst(comparatorComparingLength));
        assertThat(stringList.get(0)).isNull();
        assertThat(stringList.get(1)).isEqualTo("I");

        stringList.sort(Comparator.nullsFirst(comparatorComparingLength.reversed()));
        assertThat(stringList.get(0)).isNull();
        assertThat(stringList.get(1)).isEqualTo("Internationalization");

        stringList.sort(comparatorNullsLastComparingLengthComparingHashcode);
        assertThat(stringList.get(0)).isEqualTo("A");
        assertThat(stringList.get(stringList.size() - 1)).isNull();
    }

    @Test
    void comparator_reversed() {
        List<Student> studentList = StudentsListSupplier.get().stream()
                .sorted(comparatorComparingGpaComparingGradeReversed)
                .collect(Collectors.toList());

        Student student = studentList.get(0);

        assertThat(student.getGpa()).isEqualTo(4.0);
        assertThat(student.getGradeLevel()).isEqualTo(3);
        assertThat(student.getName()).isEqualTo("Emma Thompson");
    }

}