package com.percyvega.experiments.java8.streams.terminal;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
public class PartitioningByTest {

    @Test
    void partitioningBy1() {
        Map<Boolean, List<Student>> collect = StudentsListSupplier.get()
                .stream()
                .collect(Collectors.partitioningBy(student -> student.getGpa() >= 3.60));

        for (Map.Entry<Boolean, List<Student>> entry : collect.entrySet()) {
            log.info(entry.getKey());
            entry.getValue().forEach(log::info);
        }
    }

    @Test
    void partitioningBy2() {
        Map<Boolean, Set<Student>> collect = StudentsListSupplier.get()
                .stream()
                .collect(Collectors.partitioningBy(
                        student -> student.getGpa() >= 3.60,
                        Collectors.toSet()));

        for (Map.Entry<Boolean, Set<Student>> entry : collect.entrySet()) {
            log.info(entry.getKey());
            entry.getValue().forEach(log::info);
        }
    }

}
