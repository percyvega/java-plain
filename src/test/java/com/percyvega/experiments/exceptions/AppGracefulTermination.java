package com.percyvega.experiments.exceptions;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

/**
 * First time enter 55.
 * Second time enter -2.
 * Third time enter any letter.
 */
@Log4j2
public class AppGracefulTermination {

    public static void main(String[] args) {
        log.info("Starting main()");

        AgeReader ageReader = new AgeReaderThrowsException();

        int age = 0;

        try (Scanner scanner = new Scanner(System.in)) {

            while (age != -1) {
                log.info("About to start reading lastName.");
                age = ageReader.readAge(scanner);
                log.info("No exceptions found.");
            }

        } catch (ImpossibleAgeException e) {

            System.err.println("Starting catch{}");
            e.printStackTrace();

        } finally {

            log.info(AppGracefulTermination.class.getSimpleName() + "'s Finally");

        }

        log.info("Finishing gracefully main()");
    }

}
