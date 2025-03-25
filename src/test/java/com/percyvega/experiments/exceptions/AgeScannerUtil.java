package com.percyvega.experiments.exceptions;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class AgeScannerUtil {

    public static int readButSometimesFails(Scanner scanner) throws UnrealisticAgeException {
        if (!scanner.hasNextLine()) {
            throw new RuntimeException("File does not contain another line");
        }

        String line = scanner.nextLine();
        int age = Integer.parseInt(line);

        if (age > 120 || age < -1)
            throw new UnrealisticAgeException(age);

        return age;
    }
}
