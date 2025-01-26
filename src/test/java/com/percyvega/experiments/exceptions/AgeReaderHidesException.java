package com.percyvega.experiments.exceptions;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class AgeReaderHidesException implements AgeReader {

    @Override
    public int readAge(Scanner scanner) throws ImpossibleAgeException {
        log.info("Starting readAge()");

        int age = DEFAULT_AGE;

        try {

            log.info("Starting try{}");

            age = AgeScannerUtil.read(scanner);

        } catch (ImpossibleAgeException e) {

            System.err.println("Starting AgeReaderHidesException's catch{}");
            e.printStackTrace();

        } finally {

            log.info("Starting AgeReaderHidesException's finally{}");

        }

        log.info("Finishing readAge()");

        return age;
    }

}
