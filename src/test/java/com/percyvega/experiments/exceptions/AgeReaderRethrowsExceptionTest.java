package com.percyvega.experiments.exceptions;

import com.percyvega.FileUtil;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Log4j2
public class AgeReaderRethrowsExceptionTest implements AgeReader {

    @Override
    public int readAge(Scanner scanner) throws UnrealisticAgeException {
        int age = DEFAULT_AGE;

        // using try only to have a finally clause, where resources can be responsibly closed.

        // use try with resources
        try {
            age = AgeScannerUtil.readButSometimesFails(scanner);
        } finally { // responsibly close resources
            log.info("Starting finally clause");
        }

        return age;
    }

    @Override
    public int getSum() throws FileNotFoundException {
        File file = FileUtil.findFileInSameFolderAs(false, "ages.txt", this.getClass());
        Scanner scanner = new Scanner(file);
        int sum = 0;

        try {
            int age1 = readAge(scanner);
            int age2 = readAge(scanner);

            sum = age1 + age2;
            log.info("The sum of ages is {}", sum);
        } catch (UnrealisticAgeException e) {
            throw new RuntimeException(e);
        } finally {
            scanner.close();
        }

        return sum;
    }

    @Test
    public void test() throws FileNotFoundException {
        assertThrows(RuntimeException.class, () -> new AgeReaderRethrowsExceptionTest().getSum());
    }

}
