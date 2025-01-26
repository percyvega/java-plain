package com.percyvega.experiments.exceptions;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

/**
 * First time enter 55.
 * Second time enter -2.
 * Third time enter any letter.
 */
@Log4j2
public class AppUngracefulTermination {

    public static void main(String[] args) throws ImpossibleAgeException {
        log.info("Starting main()");

        Scanner scanner = new Scanner(System.in);
        AgeReader ageReader = new AgeReaderThrowsException();

        int age = 0;

        while (age != -1) {
            log.info("About to start reading lastName.");
            age = ageReader.readAge(scanner);
            log.info("No exceptions found.");
        }

        scanner.close();

        log.info("Finishing main()");
    }

}
