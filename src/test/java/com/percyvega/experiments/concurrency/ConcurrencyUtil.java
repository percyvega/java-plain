package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Log4j2
public class ConcurrencyUtil {

    public static final int NUMBER_OF_TASKS = 3;
    public static final int THREAD_POOL_SIZE = 2;

    public static Thread getWorkerThread() {
        return new Thread(ConcurrencyUtil::performLongTaskAndReturnRandomInt);
    }

    public static Callable<Integer> getWorkerCallable() {
        return ConcurrencyUtil::performLongTaskAndReturnRandomInt;
    }

    // Stays busy between 1 and 5 seconds and returns the number of ms it stayed busy.
    // Returns an int between 10 and 50.
    public static int performLongTaskAndReturnRandomInt() {
        int msToSleep = ThreadLocalRandom.current().nextInt(1000, 5000);

        try {
            TimeUnit.MILLISECONDS.sleep(msToSleep);
        } catch (InterruptedException e) {
            log.error("Failed to sleep for {} ms.", msToSleep);
        }
        log.info("{} took {} ms. to complete.", Thread.currentThread().getName(), msToSleep);

        return msToSleep / 100;
    }

    public static void logTimeSinceStart(long startTimeMillis) {
        log.info("Reached end after {} seconds.", (System.currentTimeMillis() - startTimeMillis) / 1000f);
    }

    public static int productOf(List<Future<Integer>> futureTasks) throws ExecutionException, InterruptedException {
        List<Integer> integerList = new ArrayList<>();
        for (Future<Integer> futureTask : futureTasks) {
            integerList.add(futureTask.get());
        }

        return integerList.stream().reduce(1, (a, b) -> a * b);
    }
}
