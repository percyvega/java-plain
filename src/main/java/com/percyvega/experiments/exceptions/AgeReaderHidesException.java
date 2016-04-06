package com.percyvega.experiments.exceptions;

import java.util.Scanner;

public class AgeReaderHidesException implements AgeReader {

    @Override
    public int readAge(Scanner scanner) throws ImpossibleAgeException {
        System.out.println("Starting readAge()");

        int age = DEFAULT_AGE;

        try {

            System.out.println("Starting try{}");

            age = AgeScannerUtil.read(scanner);

        } catch (ImpossibleAgeException e) {

            System.err.println("Starting AgeReaderHidesException's catch{}");
            e.printStackTrace();

        } finally {

            System.out.println("Starting AgeReaderHidesException's finally{}");

        }

        System.out.println("Finishing readAge()");

        return age;
    }

}
