package com.percyvega.experiments.java8.newfunctionalinterfaces.function;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class FunctionTest {

    public static final Function<String, String> upperCaseFunction1 = new Function<String, String>() {
        @Override
        public String apply(String s) {
            return s.toUpperCase();
        }
    };
    public static final Function<String, String> upperCaseFunction2 = s -> s.toUpperCase();
    public static final Function<String, String> upperCaseFunction3 = String::toUpperCase;

    public static final Function<String, String> replaceSpacesWithUnderscores = s -> s.replace(" ", "_");
    public static final Function<String, String> surroundWithTwoSpaces = s -> "  " + s + "  ";

    public static final Function<List<Student>, Double> calculateAverageGpa = students1 -> {
        return students1.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .getAsDouble();
    };

    @Test
    void toUpperCase() {
        List<String> stringList = StudentsListSupplier.get()
                .stream()
                .filter(student -> upperCaseFunction1.apply(student.getName()).equals("MATT DAMON"))
                .map(student ->
                        upperCaseFunction1.apply(student.getName()) + ", " +
                                upperCaseFunction2.apply(student.getName()) + ", " +
                                upperCaseFunction3.apply(student.getName()))
                .collect(Collectors.toList());

        assertThat(stringList.size()).isEqualTo(1);
        assertThat(stringList.get(0)).isEqualTo("MATT DAMON, MATT DAMON, MATT DAMON");
    }

    @Test
    void toUpperCase_then_replaceSpacesWithUnderscore() {
        List<String> stringList = StudentsListSupplier.get()
                .stream()
                .filter(student -> upperCaseFunction1.apply(student.getName()).equals("MATT DAMON"))
                .map(student -> upperCaseFunction3.andThen(replaceSpacesWithUnderscores).apply(student.getName()))
                .collect(Collectors.toList());

        assertThat(stringList.size()).isEqualTo(1);
        assertThat(stringList.get(0)).isEqualTo("MATT_DAMON");
    }

    @Test
    void surroundWithTwoSpaces_then_replaceSpacesWithUnderscore() {
        List<String> stringList = StudentsListSupplier.get()
                .stream()
                .filter(student -> upperCaseFunction1.apply(student.getName()).equals("MATT DAMON"))
                .map(student -> surroundWithTwoSpaces.andThen(replaceSpacesWithUnderscores).apply(student.getName()))
                .collect(Collectors.toList());

        assertThat(stringList.size()).isEqualTo(1);
        assertThat(stringList.get(0)).isEqualTo("__Matt_Damon__");
    }

    @Test
    void replaceSpacesWithUnderscore_then_surroundWithTwoSpaces() {
        List<String> stringList = StudentsListSupplier.get()
                .stream()
                .filter(student -> upperCaseFunction1.apply(student.getName()).equals("MATT DAMON"))
                .map(student -> surroundWithTwoSpaces.compose(replaceSpacesWithUnderscores).apply(student.getName()))
                .collect(Collectors.toList());

        assertThat(stringList.size()).isEqualTo(1);
        assertThat(stringList.get(0)).isEqualTo("  Matt_Damon  ");
    }

    @Test
    void calculateAverageGpa() {
        assertThat(calculateAverageGpa.apply(StudentsListSupplier.get())).isCloseTo(3.586, Offset.offset(.001));
    }
}
