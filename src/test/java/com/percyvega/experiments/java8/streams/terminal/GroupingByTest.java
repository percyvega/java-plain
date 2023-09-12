package com.percyvega.experiments.java8.streams.terminal;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

@Log4j2
public class GroupingByTest {

    @Test
    void groupingBy_gender() {
        Map<String, List<Student>> studentsByGender = StudentsListSupplier.get()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));

        for (Map.Entry<String, List<Student>> entry : studentsByGender.entrySet()) {
            log.info(entry.getKey());
            entry.getValue().forEach(log::info);
            System.out.println();
        }
    }

    @Test
    void groupingBy_customized() {
        Map<String, List<Student>> studentsByGender = StudentsListSupplier.get()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() > 3.75 ? "OUTSTANDING" : "AVERAGE"));

        for (Map.Entry<String, List<Student>> entry : studentsByGender.entrySet()) {
            log.info(entry.getKey());
            entry.getValue().forEach(log::info);
            System.out.println();
        }
    }

    @Test
    void two_level_mapping_1() {
        Map<String, Map<String, List<Student>>> collect = StudentsListSupplier.get()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getGender,
                                Collectors.groupingBy(student -> student.getGpa() > 3.75 ? "OUTSTANDING" : "AVERAGE")));

        for (Map.Entry<String, Map<String, List<Student>>> mapEntry : collect.entrySet()) {
            log.info(mapEntry.getKey());
            Map<String, List<Student>> value = mapEntry.getValue();
            for (Map.Entry<String, List<Student>> stringListEntry : value.entrySet()) {
                log.info(stringListEntry.getKey());
                stringListEntry.getValue().forEach(log::info);
                System.out.println();
            }
            System.out.println();
        }
    }

    @Test
    void two_level_mapping_2() {
        Map<String, Integer> notebooksByGender = StudentsListSupplier.get()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getGender,
                                Collectors.summingInt(Student::getNoteBooks)));

        for (Map.Entry<String, Integer> entry : notebooksByGender.entrySet()) {
            log.info(entry.getKey());
            log.info(entry.getValue());
            System.out.println();
        }
    }

    @Test
    void two_level_mapping_3() {
        LinkedHashMap<String, Set<Student>> collect = StudentsListSupplier.get()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getGender,
                                LinkedHashMap::new,
                                Collectors.toSet()));

        for (Map.Entry<String, Set<Student>> entry : collect.entrySet()) {
            log.info(entry.getKey());
            for (Student student : entry.getValue()) {
                log.info(student);
            }
            System.out.println();
        }
    }

    @Test
    void maxBy1() {
        Map<Integer, Optional<Student>> collect = StudentsListSupplier.get()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getGradeLevel,
                                Collectors.maxBy(Comparator.comparingDouble(Student::getGpa))));

        for (Map.Entry<Integer, Optional<Student>> entry : collect.entrySet()) {
            log.info(entry.getKey());
            log.info(entry.getValue());
            System.out.println();
        }
    }

    @Test
    void maxBy2() {
        Map<Integer, Student> collect = StudentsListSupplier.get()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getGradeLevel,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingDouble(Student::getGpa)),
                                        Optional::get)));

        for (Map.Entry<Integer, Student> entry : collect.entrySet()) {
            log.info(entry.getKey());
            log.info(entry.getValue());
            System.out.println();
        }
    }

    @Test
    void minBy() {
        Map<String, Optional<Student>> collect = StudentsListSupplier.get()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getGender,
                                Collectors.minBy(Comparator.comparingDouble(Student::getGpa))));

        for (Map.Entry<String, Optional<Student>> entry : collect.entrySet()) {
            log.info(entry.getKey());
            log.info(entry.getValue());
            System.out.println();
        }
    }

}
