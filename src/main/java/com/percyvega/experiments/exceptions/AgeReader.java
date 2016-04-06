package com.percyvega.experiments.exceptions;

import java.util.Scanner;

public interface AgeReader {
    int DEFAULT_AGE = 35;

    int readAge(Scanner scanner) throws ImpossibleAgeException;
}
