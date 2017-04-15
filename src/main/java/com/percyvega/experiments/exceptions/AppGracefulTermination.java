package com.percyvega.experiments.exceptions;

import java.util.Scanner;

/**
 * First time enter 55.
 * Second time enter -2.
 * Third time enter any letter.
 */
public class AppGracefulTermination {

    public static void main(String[] args) {
        System.out.println("Starting main()");

        AgeReader ageReader = new AgeReaderThrowsException();

        int age = 0;

        try(Scanner scanner = new Scanner(System.in)) {

            while (age != -1) {
                System.out.println("About to start reading age.");
                age = ageReader.readAge(scanner);
                System.out.println("No exceptions found.");
            }

        } catch (ImpossibleAgeException e) {

            System.err.println("Starting catch{}");
            e.printStackTrace();

        } finally {

            System.out.println(AppGracefulTermination.class.getSimpleName() + "'s Finally");

        }

        System.out.println("Finishing gracefully main()");
    }

}
