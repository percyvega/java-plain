package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;

import java.text.MessageFormat;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Log4j2
public class ConcurrencyUtil {

    public static final int NUMBER_OF_TASKS = 10;
    public static final int THREAD_POOL_SIZE = 4;

    public static Thread getWorkerThread() {
        return new Thread(ConcurrencyUtil::performLongTask);
    }

    public static Callable<String> getWorkerCallable() {
        return ConcurrencyUtil::performLongTask;
    }

    // stays busy between 1 and 10 seconds and returns the number of ms it stayed busy
    public static String performLongTask() {
        int msToSleep = ThreadLocalRandom.current().nextInt(1000, 10000);
        log.info("About to sleep for {} ms.", msToSleep);

        try {
            TimeUnit.MILLISECONDS.sleep(msToSleep);
            log.info("Done sleeping for {} ms.", msToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info("Failed to sleep for {} ms.", msToSleep);
        }
        return MessageFormat.format("{0} took {1} ms. to complete.", Thread.currentThread().getName(), msToSleep);
    }

    public static void logTimeSinceStart(long startTimeMillis) {
        log.info("Reached end after {} seconds.", (System.currentTimeMillis() - startTimeMillis) / 1000f);
    }

}
