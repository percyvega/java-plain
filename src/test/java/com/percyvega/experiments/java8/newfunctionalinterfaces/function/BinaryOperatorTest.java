package com.percyvega.experiments.java8.newfunctionalinterfaces.function;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static com.percyvega.experiments.java8.model.Constants.FEMALE;
import static com.percyvega.experiments.java8.model.Constants.MALE;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BinaryOperatorTest {

    public static final BinaryOperator<List<Student>> addTwoStudentLists = (students1, students2) -> {
        students1.addAll(students2);
        return students1;
    };

    @Test
    void test_addTwoStudentLists() {
        List<Student> maleStudents = StudentsListSupplier.get().stream()
                .filter(student -> MALE.equals(student.getGender()))
                .collect(Collectors.toList());
        List<Student> femaleStudents = StudentsListSupplier.get().stream()
                .filter(student -> FEMALE.equals(student.getGender()))
                .collect(Collectors.toList());

        List<Student> maleFemaleStudents = addTwoStudentLists.apply(maleStudents, femaleStudents);

        assertThat(maleFemaleStudents.size()).isEqualTo(StudentsListSupplier.get().size());
    }

}
