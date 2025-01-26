package com.percyvega.experiments.exceptions;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

/**
 * First time enter 55.
 * Second time enter -2.
 * Third time enter any letter.
 * Kill the app.
 */
@Log4j2
public class AppExceptionResistant {

    public static void main(String[] args) {
        log.info("Starting main()");

        Scanner scanner = new Scanner(System.in);
        AgeReader ageReader = new AgeReaderThrowsException();

        int age = 0;

        while (age != -1) {
            log.info("About to start reading lastName.");

            try {

                age = ageReader.readAge(scanner);
                log.info("No exceptions found.");

            } catch (ImpossibleAgeException e) {

                System.err.println("Starting catch{}");
                e.printStackTrace();

            }
        }

        scanner.close();

        log.info("Finishing main()");
    }

}
