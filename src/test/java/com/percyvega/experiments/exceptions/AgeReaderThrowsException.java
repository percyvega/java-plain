package com.percyvega.experiments.exceptions;

import java.util.Scanner;

public class AgeReaderThrowsException implements AgeReader {

    @Override
    public int readAge(Scanner scanner) throws ImpossibleAgeException {
        System.out.println("Starting readAge()");

        int age = AgeScannerUtil.read(scanner);

        System.out.println("Finishing readAge()");

        return age;
    }

}
