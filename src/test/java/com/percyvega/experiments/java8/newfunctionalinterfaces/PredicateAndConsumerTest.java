package com.percyvega.experiments.java8.newfunctionalinterfaces;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.percyvega.experiments.java8.model.Constants.FEMALE;
import static com.percyvega.experiments.java8.model.Constants.MALE;

@Log4j2
class PredicateAndConsumerTest {

    private static final Consumer<Student> logStudentNameConsumer = student -> log.info(student::getName);
    private static final Consumer<Student> logStudentGpaConsumer = student -> log.info(student::getGpa);

    public static final Predicate<Student> gpaGt35MaleStudentPredicate = student -> MALE.equals(student.getGender()) && student.getGpa() > 3.5;
    public static final Predicate<Student> gpaLt35FemaleStudentPredicate = student -> FEMALE.equals(student.getGender()) && student.getGpa() < 3.5;

    public static final Consumer<Student> compositeConsumer = student -> {
        if (gpaGt35MaleStudentPredicate.or(gpaLt35FemaleStudentPredicate).test(student)) {
            logStudentNameConsumer.andThen(logStudentGpaConsumer).accept(student);
        }
    };

    @Test
    void test1() {
        StudentsListSupplier.get().forEach(compositeConsumer);
    }

    @Test
    void test2() {
        StudentsListSupplier.get().stream()
                .filter(gpaGt35MaleStudentPredicate.or(gpaLt35FemaleStudentPredicate))
                .forEach(logStudentNameConsumer.andThen(logStudentGpaConsumer));
    }

}
