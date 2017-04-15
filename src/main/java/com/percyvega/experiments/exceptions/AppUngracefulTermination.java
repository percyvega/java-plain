package com.percyvega.experiments.exceptions;

import java.util.Scanner;

/**
 * First time enter 55.
 * Second time enter -2.
 * Third time enter any letter.
 */
public class AppUngracefulTermination {

    public static void main(String[] args) throws ImpossibleAgeException {
        System.out.println("Starting main()");

        Scanner scanner = new Scanner(System.in);
        AgeReader ageReader = new AgeReaderThrowsException();

        int age = 0;

        while (age != -1) {
            System.out.println("About to start reading age.");
            age = ageReader.readAge(scanner);
            System.out.println("No exceptions found.");
        }

        scanner.close();

        System.out.println("Finishing main()");
    }

}
