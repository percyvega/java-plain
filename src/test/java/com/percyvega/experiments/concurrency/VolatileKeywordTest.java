package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 * The volatile keyword makes threads read keepRunningVolatile directly from memory (as opposed to them reading their cached copies).
 * <p>
 * When the volatile keyword is removed, thread2 reads from its cached copy,
 * but since it is going through a loop, it doesn't always refresh its copy.
 * When this happens, thread2 wil continue processing and will not die.
 */
@Log4j2
public class VolatileKeywordTest {

    private /**/ volatile /**/ boolean keepRunningVolatile = true;

    public void processThis() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            int counter = 0;
            while (counter <= 1_000_000) {
                if (counter % 100_000 == 0) {
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("Counter: {}. keepRunning: {}", counter, keepRunningVolatile);
                }
                counter++;
            }
            log.info("Thread1 finished processing.");
        });

        Thread thread2 = new Thread(() -> {
            int counter = 0;
            while (keepRunningVolatile) { // when keepRunningVolatile is not volatile, there is no guarantee the thread will notice its value changes
                counter++;
                // practically any other statement will allow thread1 to notice keepRunning's change
                // log.info("Counter: {}", counter);
            }
            log.info("Thread2 finished. Counted up to {}", counter);
        });

        thread1.start();
        thread2.start();

        thread1.join();
        keepRunningVolatile = false;

        int i = 0;
        while (thread2.isAlive()) {
            log.info("Thread2 is still alive and kicking even though keepRunning is {}!!!!", keepRunningVolatile);
            Thread.sleep(1_000);
            if (i++ == 5) {
                log.info("About to exit");
                return;
            }
        }

        log.info("About to run thread2.join()");
        thread2.join();
        log.info("Thread2 finished");
    }

    @Test
    void test() throws InterruptedException {
        new VolatileKeywordTest().processThis();
    }

}
