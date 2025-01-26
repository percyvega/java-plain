package com.percyvega.experiments.java8.streams.intermediatestateful;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import com.percyvega.experiments.java8.model.suppliers.StudentsWithNullListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Log4j2
class SortedTest {

    public static final Comparator<Student> STUDENT_COMPARATOR = Comparator.comparingDouble(Student::getGpa).thenComparingDouble(Student::getGradeLevel).reversed();
    public static final Consumer<Student> STUDENT_CONSUMER = student -> log.info(student.getGpa() + ", " + student.getGradeLevel() + ", " + student.getName());

    @Test
    void sorted() {
        Stream.of("Percy", "Fran", "Nico", "Isabella")
                .sorted()
                .forEach(log::info);
    }

    @Test
    void list_sort() {
        List<Student> studentList = StudentsListSupplier.get();
        studentList
                .sort(STUDENT_COMPARATOR);
        studentList
                .forEach(STUDENT_CONSUMER);
    }

    @Test
    void sorted_comparator() {
        StudentsListSupplier.get().stream()
                .sorted(STUDENT_COMPARATOR)
                .forEach(STUDENT_CONSUMER);
    }

    @Test
    void list_sort_with_nulls() {
        List<Student> studentList = StudentsWithNullListSupplier.get();
        studentList
                .sort(Comparator.nullsFirst(STUDENT_COMPARATOR));
        studentList
                .forEach(log::info);
        studentList
                .stream()
                .filter(Objects::nonNull)
                .forEach(STUDENT_CONSUMER);
    }

}
