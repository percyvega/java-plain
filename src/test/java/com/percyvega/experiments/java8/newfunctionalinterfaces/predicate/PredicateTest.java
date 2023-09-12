package com.percyvega.experiments.java8.newfunctionalinterfaces.predicate;

import com.percyvega.experiments.java8.model.Student;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Predicate;

import static com.percyvega.experiments.java8.model.Constants.MALE;
import static com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier.*;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class PredicateTest {

    private static final Predicate<Integer> divisibleBy4Predicate = integer -> integer % 4 == 0;
    private static final Predicate<Integer> divisibleBy100Predicate = integer -> integer % 100 == 0;
    private static final Predicate<Integer> divisibleBy400Predicate = integer -> integer % 400 == 0;

    public static final Predicate<Integer> isLeapYear = divisibleBy4Predicate.and(divisibleBy100Predicate.negate()).or(divisibleBy400Predicate);

    public static final Predicate<Student> gpaGt35MaleStudentPredicate = student -> MALE.equals(student.getGender()) && student.getGpa() >= 3.5;

    @Test
    void divisibleBy4PredicateTest() {
        assertThat(divisibleBy4Predicate.test(4)).isTrue();
        assertThat(divisibleBy4Predicate.test(11)).isFalse();
    }

    @Test
    void divisibleBy100PredicateTest() {
        assertThat(divisibleBy100Predicate.test(100)).isTrue();
        assertThat(divisibleBy100Predicate.test(200)).isTrue();
        assertThat(divisibleBy100Predicate.test(111)).isFalse();
    }

    @Test
    void divisibleBy400PredicateTest() {
        assertThat(divisibleBy400Predicate.test(400)).isTrue();
        assertThat(divisibleBy400Predicate.test(1200)).isTrue();
        assertThat(divisibleBy400Predicate.test(1111)).isFalse();
    }

    @Test
    void isLeapYear_Test() {
        Arrays.asList(1596, 1600, 2000, 2400).forEach(integer -> {
            assertThat(isLeapYear.test(integer)).isTrue();
        });
        Arrays.asList(1697, 1698, 1699, 1700, 1800, 1900, 2100, 2200, 2300).forEach(integer -> {
            assertThat(isLeapYear.test(integer)).isFalse();
        });
    }

    @Test
    void gpa4MaleStudentPredicateTest() {
        assertThat(gpaGt35MaleStudentPredicate.test(MATT)).isTrue();
        assertThat(gpaGt35MaleStudentPredicate.test(EMMA)).isFalse();
        assertThat(gpaGt35MaleStudentPredicate.test(BRAD)).isTrue();
        assertThat(gpaGt35MaleStudentPredicate.test(MERYL)).isFalse();
    }

}
