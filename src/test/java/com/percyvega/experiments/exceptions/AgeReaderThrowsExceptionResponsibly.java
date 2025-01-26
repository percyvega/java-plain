package com.percyvega.experiments.exceptions;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class AgeReaderThrowsExceptionResponsibly implements AgeReader {

    @Override
    public int readAge(Scanner scanner) throws ImpossibleAgeException {
        log.info("Starting readAge()");

        int age = DEFAULT_AGE;

        try { // using try only to have the finally, where resources are responsibly closed

            log.info("Starting try{}");

            age = AgeScannerUtil.read(scanner);

        } finally { // responsibly close resources

            log.info("Starting AgeReaderHidesException's finally{}");

        }

        log.info("Finishing readAge()");

        return age;
    }

}
