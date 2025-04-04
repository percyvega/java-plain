package com.percyvega.experiments.exceptions;

import com.percyvega.FileUtil;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class AgeReaderLogsButHidesExceptionTest implements AgeReader {

    @Override
    public int readAge(Scanner scanner) {
        int age = 0;

        try {
            age = AgeScannerUtil.readButSometimesFails(scanner);
        } catch (UnrealisticAgeException e) {
            log.error("Starting catch clause", e);
        }

        return age;
    }

    @Override
    public int getSum() throws FileNotFoundException {
        File file = FileUtil.findFileInSameFolderAs(false, "ages.txt", this.getClass());
        Scanner scanner = new Scanner(file);

        int age1 = readAge(scanner);
        int age2 = readAge(scanner);
        int sum = age1 + age2;
        log.info("The sum of ages is {}", sum);
        scanner.close();

        return sum;
    }

    @Test
    public void test() throws FileNotFoundException {
        assertThat(new AgeReaderLogsButHidesExceptionTest().getSum()).isEqualTo(12);
    }

}
