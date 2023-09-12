package com.percyvega.experiments.java8.newfunctionalinterfaces.function;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.percyvega.experiments.java8.newfunctionalinterfaces.predicate.PredicateTest.gpaGt35MaleStudentPredicate;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BiFunctionTest {

    public static final BiFunction<List<Student>, Predicate<Student>, List<Student>> getNamesOfStudents = (students, studentPredicate) ->
            StudentsListSupplier.get().stream()
                    .filter(studentPredicate)
                    .collect(Collectors.toList());

    @Test
    void getNamesOfStudentsTest() {
        List<Student> studentList = getNamesOfStudents.apply(StudentsListSupplier.get(), gpaGt35MaleStudentPredicate);
        assertThat(studentList.size()).isEqualTo(6);
    }

}
