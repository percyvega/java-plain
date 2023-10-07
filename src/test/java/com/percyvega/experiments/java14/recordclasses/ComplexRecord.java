package com.percyvega.experiments.java14.recordclasses;

import lombok.extern.log4j.Log4j2;
import org.fluttercode.datafactory.impl.DataFactory;

import java.time.LocalDate;
import java.util.Objects;

@Log4j2
public record ComplexRecord(String name, int age) implements Runnable {

    static String DEFAULT_NAME = "Unknown";
    static int DEFAULT_AGE = 100;

    int getBirthYearFromAge(int age) {
        return LocalDate.now().getYear() - age;
    }

    // Compact form (as opposed to canonical form).
    // Implicit parameters name and age.
    // Method code gets run before setting fields.
    public ComplexRecord {
        Objects.requireNonNull(name);

        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be " + age);
        }

        log.info("Birth year: {}", getBirthYearFromAge(age));
    }

    public ComplexRecord(String name) {
        this(name, DEFAULT_AGE);
    }

    public ComplexRecord(int age) {
        this(DEFAULT_NAME, age);
    }

    public ComplexRecord() {
        this(DEFAULT_NAME, DEFAULT_AGE);
    }

    @Override
    public void run() {
        DataFactory dataFactory = new DataFactory();

        for (int i = 0; i < 5; i++) {

            log.info(
                    new ComplexRecord(
                            dataFactory.getFirstName(),
                            dataFactory.getNumberUpTo(100)
                    )
            );

        }

    }
}
