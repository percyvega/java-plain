package com.percyvega.experiments.concurrency.util;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
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

    public static Callable<Integer> getWorkerCallable(CountDownLatch countDownLatch) {
        return new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int randomInt = performLongTaskAndReturnRandomInt();
                countDownLatch.countDown();
                return randomInt;
            }
        };
    }

    /**
     * For threading purposes, this is practically a Callable<Integer> task.
     * It stays busy (sleeping ;) for a random time between 1000 and 5000 ms.
     *
     * @return a random number between 0 (inclusive) and 30 (exclusive).
     */
    public static int performLongTaskAndReturnRandomInt() {
        int msToSleep = ThreadLocalRandom.current().nextInt(1000, 5000);

        try {
            log.info("{} STARTING to work for {} ms.", Thread.currentThread().getName(), msToSleep);
            TimeUnit.MILLISECONDS.sleep(msToSleep);
        } catch (InterruptedException e) {
            log.error("FAILED to work for {} ms.", msToSleep);
        }
        int randomInt = ThreadLocalRandom.current().nextInt(0, 30);
        log.info("{} FINISHED working for {} ms. and returning {}", Thread.currentThread().getName(), msToSleep, randomInt);

        return randomInt;
    }

    public static int sumOf(List<Future<Integer>> futureTasks) throws ExecutionException, InterruptedException {
        List<Integer> integerList = new ArrayList<>();
        for (Future<Integer> futureTask : futureTasks) {
            integerList.add(futureTask.get()); // get() blocks until task is completed
        }

        return integerList.stream().reduce(0, Integer::sum);
    }

}
