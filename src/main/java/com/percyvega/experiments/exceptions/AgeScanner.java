package com.percyvega.experiments.exceptions;

import java.util.Scanner;

/**
 * Created by percy on 1/7/2016.
 */
public class AgeScanner {

    public final static int DEFAULT_AGE = 35;

    public int readAge(Scanner scanner) {
        System.out.println("Starting readAge()");

        int age = DEFAULT_AGE;
        String ageEntry;

        try {

            System.out.println("Starting try{}");

            System.out.println("Enter an age in years (-1 to exit): ");
            ageEntry = scanner.next();
            age = Integer.parseInt(ageEntry);

            if(age > 120 || age < -1)
                throw new ImpossibleAgeException(age);

            System.out.println("No exceptions found. Age entered: " + age);

        } catch (ImpossibleAgeException e) {

            System.err.println("Starting AgeScanner's catch{}");
            e.printStackTrace();

        } finally {

            System.out.println("Starting AgeScanner's finally{}");

        }

        System.out.println("Finishing readAge()");

        return age;
    }

}
