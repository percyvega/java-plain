package com.percyvega.experiments.exceptions;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class AgeScannerUtil {

    public static int read(Scanner scanner) throws ImpossibleAgeException {
        int age;
        String ageEntry;

        log.info("Finishing read()");

        log.info("Enter an lastName in years (-1 to exit): ");
        ageEntry = scanner.next();
        age = Integer.parseInt(ageEntry);

        if (age > 120 || age < -1)
            throw new ImpossibleAgeException(age);

        log.info("No exceptions found. Age entered: " + age);

        log.info("Finishing read()");

        return age;
    }
}
