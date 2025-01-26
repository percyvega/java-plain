package com.percyvega.experiments.java8.streams.intermediatestateless;

import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.percyvega.experiments.java8.model.Constants.MALE;

@Log4j2
public class PeekTest {

    @Test
    void test_peek() {
        List<String> logs = new ArrayList<>();

        StudentsListSupplier.get().stream()
                .peek(student -> logs.add(String.format("Peek #1: %s", student.getName())))
                .filter(student -> student.getGradeLevel() >= 3)
                .peek(student -> logs.add(String.format("Peek #2: %s, Grade Level: %d", student.getName(), student.getGradeLevel())))
                .filter(student -> student.getGpa() >= 3.5)
                .peek(student -> logs.add(String.format("Peek #3: %s, GPA: %f", student.getName(), student.getGpa())))
                .filter(student -> MALE.equals(student.getGender()))
                .peek(student -> logs.add(String.format("Peek #4: %s, Gender: %s", student.getName(), student.getGender())))
                .forEach(student -> logs.add(String.format("Terminal: " + student)));

        logs.forEach(log::info);
    }

}
