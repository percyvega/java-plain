package com.percyvega.experiments.exceptions;

import java.util.Scanner;

public class AgeReaderThrowsExceptionResponsibly implements AgeReader {

    @Override
    public int readAge(Scanner scanner) throws ImpossibleAgeException {
        System.out.println("Starting readAge()");

        int age = DEFAULT_AGE;

        try { // using try only to have the finally, where resources are responsibly closed

            System.out.println("Starting try{}");

            age = AgeScannerUtil.read(scanner);

        } finally { // responsibly close resources

            System.out.println("Starting AgeReaderHidesException's finally{}");

        }

        System.out.println("Finishing readAge()");

        return age;
    }

}
