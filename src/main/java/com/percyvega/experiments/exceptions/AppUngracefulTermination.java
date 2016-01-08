package com.percyvega.experiments.exceptions;

import java.util.Scanner;

/**
 * Created by percy on 1/7/2016.
 */
public class AppUngracefulTermination {

    public static void main(String[] args) {
        System.out.println("Starting main()");

        Scanner scanner = new Scanner(System.in);
        AgeScanner ageScanner = new AgeScanner();

        int age = 0;

        while (age != -1) {
            System.out.println("About to start reading age.");
            age = ageScanner.readAge(scanner);
            System.out.println("No unchecked exceptions were found. Finished reading age.");
        }

        scanner.close();

        System.out.println("Finishing main()");
    }

}
