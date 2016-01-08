package com.percyvega.experiments.exceptions;

import java.util.Scanner;

/**
 * Created by percy on 1/7/2016.
 */
public class AppGracefulTermination {

    public static void main(String[] args) {
        System.out.println("Starting main()");

        Scanner scanner = new Scanner(System.in);
        AgeScanner ageScanner = new AgeScanner();

        int age = 0;

        try {

            while (age != -1) {
                System.out.println("About to start reading age.");
                age = ageScanner.readAge(scanner);
                System.out.println("No unchecked exceptions were found. Finished reading age.");
            }

        } catch (RuntimeException e) {

            System.err.println("Starting " + AppGracefulTermination.class.getSimpleName() + "'s catch{}");
            System.err.println("An unchecked exception was caught!");
            e.printStackTrace();

        } finally {

            System.out.println(AppGracefulTermination.class.getSimpleName() + "'s Finally");
            scanner.close();

        }

        System.out.println("Finishing gracefully main()");
    }

}
