package com.percyvega.experiments.java8.newfunctionalinterfaces.function;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier.*;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class UnaryOperatorTest {

    public static final UnaryOperator<List<Student>> studentsWithGpaGreaterThan35 = studentList -> studentList.stream()
            .filter(student -> student.getGpa() > 3.5)
            .collect(Collectors.toList());

    @Test
    void test_studentsWithGpaGreaterThan35() {
        assertThat(studentsWithGpaGreaterThan35.apply(StudentsListSupplier.get())).containsOnly(MATT, GEORGE, JOHNNY, CLINT, CATE, EMMA, JODIE);
        assertThat(studentsWithGpaGreaterThan35.apply(StudentsListSupplier.get())).doesNotContain(BRAD);
    }

}
