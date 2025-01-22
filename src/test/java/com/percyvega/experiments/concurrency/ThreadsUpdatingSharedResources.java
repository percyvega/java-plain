package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Because of race condition, even when using volatile, you will see results like this one:
 * 2025-01-21 01:30:14,255172 INFO [main] volatileCounter: 1,993,767
 * 2025-01-21 01:30:14,256862 INFO [main] counter: 1,995,441
 * 2025-01-21 01:30:14,256965 INFO [main] synchronizedCounter: 2,000,000
 * 2025-01-21 01:30:14,257115 INFO [main] atomicCounter: 2,000,000
 */
@Log4j2
public class ThreadsUpdatingSharedResources {

    private long counter = 0;
    private long synchronizedCounter = 0;
    private volatile long volatileCounter = 0;
    private final AtomicLong atomicCounter = new AtomicLong(0);

    public ThreadsUpdatingSharedResources() throws InterruptedException {
        Runnable myRunnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                volatileCounter++;
                counter++;
                synchronized (ThreadsUpdatingSharedResources.class) {
                    synchronizedCounter++;
                }
                atomicCounter.addAndGet(1);
            }
        };
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log.info("volatileCounter: {}", volatileCounter);
        log.info("counter: {}", counter);
        log.info("synchronizedCounter: {}", synchronizedCounter);
        log.info("atomicCounter: {}", atomicCounter);
    }

    @Test
    void test() throws InterruptedException {
        // no need to instantiate class for it to run automatically via its constructor
    }

}
