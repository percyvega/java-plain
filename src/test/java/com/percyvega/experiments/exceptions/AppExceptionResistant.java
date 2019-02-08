package com.percyvega.experiments.exceptions;

import java.util.Scanner;

/**
 * First time enter 55.
 * Second time enter -2.
 * Third time enter any letter.
 * Kill the app.
 */
public class AppExceptionResistant {

    public static void main(String[] args) {
        System.out.println("Starting main()");

        Scanner scanner = new Scanner(System.in);
        AgeReader ageReader = new AgeReaderThrowsException();

        int age = 0;

        while (age != -1) {
            System.out.println("About to start reading age.");

            try {

                age = ageReader.readAge(scanner);
                System.out.println("No exceptions found.");

            } catch (ImpossibleAgeException e) {

                System.err.println("Starting catch{}");
                e.printStackTrace();

            }
        }

        scanner.close();

        System.out.println("Finishing main()");
    }

}
