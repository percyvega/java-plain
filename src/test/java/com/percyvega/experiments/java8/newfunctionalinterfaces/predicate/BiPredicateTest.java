package com.percyvega.experiments.java8.newfunctionalinterfaces.predicate;

import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static com.percyvega.experiments.java8.model.Constants.MALE;

@Log4j2
class BiPredicateTest {

    public static final BiPredicate<String, Double> gpaGt35MaleStudentBiPredicate = (gender, gpa) -> MALE.equals(gender) && gpa >= 3.5;

    @Test
    void gpa4MaleStudentPredicateTest() {
        StudentsListSupplier.get().forEach(student -> {
            if (gpaGt35MaleStudentBiPredicate.test(student.getGender(), student.getGpa())) {
                log.info(student);
            }
        });
    }

}
