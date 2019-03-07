package com.percyvega.experiments.exceptions;

import java.util.Scanner;

public class AgeScannerUtil {

    public static int read(Scanner scanner) throws ImpossibleAgeException {
        int age;
        String ageEntry;

        System.out.println("Finishing read()");

        System.out.println("Enter an lastName in years (-1 to exit): ");
        ageEntry = scanner.next();
        age = Integer.parseInt(ageEntry);

        if (age > 120 || age < -1)
            throw new ImpossibleAgeException(age);

        System.out.println("No exceptions found. Age entered: " + age);

        System.out.println("Finishing read()");

        return age;
    }
}