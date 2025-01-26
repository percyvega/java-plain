package com.percyvega.experiments.java8.streams.parallel;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ParallelStreamTest {

    private static final int BIG_NUMBER = Integer.MAX_VALUE - 1;
    private static final int TIMES = 4;

    public static int sequentialSum() {
        return IntStream
                .rangeClosed(1, BIG_NUMBER)
                .sum();
    }

    public static int parallelSum() {
        return IntStream
                .rangeClosed(1, BIG_NUMBER)
                .parallel()
                .sum();
    }

    @Test
    void run_sequential() {
        runManyTimes(ParallelStreamTest::sequentialSum);
    }

    @Test
    void run_parallel() {
        runManyTimes(ParallelStreamTest::parallelSum);
    }

    private static void runManyTimes(Supplier<Integer> supplier) {
        long total = 0;
        for (int i = 0; i < TIMES; i++) {
            total += supplier.get();
        }
        assertThat(total).isEqualTo(4294967300L);
    }

}
