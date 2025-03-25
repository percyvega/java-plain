package com.percyvega.experiments.exceptions;

import java.io.FileNotFoundException;
import java.util.Scanner;

public interface AgeReader {
    int DEFAULT_AGE = 35;

    int readAge(Scanner scanner) throws UnrealisticAgeException;

    int getSum() throws FileNotFoundException;
}
