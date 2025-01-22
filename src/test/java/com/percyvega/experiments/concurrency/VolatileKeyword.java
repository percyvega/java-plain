package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 * Supposedly, if we remove the volatile keyword from line 11, then runnable1 will be so busy it won't even notice the change in value of isToStop.
 * In reality, my Mac may be so fast that runnable1 is actually always checking for isToStop.
 */
@Log4j2
public class VolatileKeyword {

    private volatile boolean isToStop = false;

    private final Runnable runnable1 = () -> {
        while (!isToStop) {
            log.error("1111111 Millis delta: {}. isToStop: {}", System.currentTimeMillis(), isToStop);
        }
    };

    private final Runnable runnable2 = () -> {
        int counter = 0;
        while (!isToStop) {
            counter++;
            if (counter % 10_000 == 0) {
                log.error("2222222 Counter: {}. Millis delta: {}. isToStop: {}", counter, System.currentTimeMillis(), isToStop);
            }
            if (counter >= 1_000_000) {
                log.info("------- About to set isToStop to true. Millis delta: {}. isToStop: {}", System.currentTimeMillis(), isToStop);
                isToStop = true;
                log.info("======= This should be the last log. Millis delta: {}. isToStop: {}", System.currentTimeMillis(), isToStop);
            }
        }
    };

    public VolatileKeyword() throws InterruptedException {
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    @Test
    void test() throws InterruptedException {
        // no need to instantiate class for it to run automatically via its constructor
    }

}
