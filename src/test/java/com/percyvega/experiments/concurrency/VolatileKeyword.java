package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;

/**
 * Supposedly, if we remove the volatile keyword from line 11, then runnable1 will be so busy it won't even notice the change in value of isToStop.
 * In reality, my Mac may be so fast that runnable1 actually is always checking for isToStop.
 */
@Log4j2
public class VolatileKeyword {

    private static final long START_NANO_TIME = System.nanoTime();
    private static volatile boolean isToStop = false;

    private static final Runnable runnable1 = () -> {
        while (!isToStop) {
            log.info("runnable1 still running at {}", System.nanoTime() - START_NANO_TIME);
        }
    };

    private static final Runnable runnable2 = () -> {
        int counter = 0;
        while (true) {
            counter++;
            if (counter >= 100_000_000) {
                log.info("About to set isToStop to true at {}", System.nanoTime() - START_NANO_TIME);
                isToStop = true;
                log.info("This should be the last log at {}", System.nanoTime() - START_NANO_TIME);
                break;
            }
            if (counter % 1_000 == 0) {
                log.info("Current value: {} at {}", counter, System.nanoTime() - START_NANO_TIME);
            }
        }
    };

    public static void main(String[] args) {
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }

}
