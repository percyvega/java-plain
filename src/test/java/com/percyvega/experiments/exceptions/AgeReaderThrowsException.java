package com.percyvega.experiments.exceptions;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class AgeReaderThrowsException implements AgeReader {

    @Override
    public int readAge(Scanner scanner) throws ImpossibleAgeException {
        log.info("Starting readAge()");

        int age = AgeScannerUtil.read(scanner);

        log.info("Finishing readAge()");

        return age;
    }

}
