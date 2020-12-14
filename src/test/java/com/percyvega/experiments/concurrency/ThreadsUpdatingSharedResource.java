package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Because of race condition, even when using volatile, you will see results like this one:
 * 2020-12-13 14:30:31,758210 INFO [Thread-0] counter: 1896322
 * 2020-12-13 14:30:31,758212 INFO [Thread-1] counter: 1966285
 * 2020-12-13 14:30:31,760966 INFO [Thread-0] synchronizedCounter: 2000000
 * 2020-12-13 14:30:31,760987 INFO [Thread-1] synchronizedCounter: 2000000
 * 2020-12-13 14:30:31,761097 INFO [Thread-0] volatileCounter: 1999457
 * 2020-12-13 14:30:31,761123 INFO [Thread-1] volatileCounter: 1999457
 * 2020-12-13 14:30:31,761199 INFO [Thread-0] atomicCounter: 2000000
 * 2020-12-13 14:30:31,761200 INFO [Thread-1] atomicCounter: 2000000
 */
@Log4j2
public class ThreadsUpdatingSharedResource {

    private static long counter = 0;
    private static long synchronizedCounter = 0;
    private static volatile long volatileCounter = 0;
    private static final AtomicLong atomicCounter = new AtomicLong(0);

    private static final Runnable RUNNABLE = () -> {
        for (int i = 0; i < 1_000_000; i++) {
            counter++;
            synchronized (ThreadsUpdatingSharedResource.class) {
                synchronizedCounter++;
            }
            volatileCounter++;
            atomicCounter.addAndGet(1);
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(RUNNABLE);
        thread1.start();
        Thread thread2 = new Thread(RUNNABLE);
        thread2.start();

        thread1.join();
        thread2.join();

        log.info("counter: {}", counter);
        log.info("synchronizedCounter: {}", synchronizedCounter);
        log.info("volatileCounter: {}", volatileCounter);
        log.info("atomicCounter: {}", atomicCounter);
    }

}
