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

    private record WorkerRecordRunnableWithLatch(CountDownLatch latch) implements Runnable {
        @Override
        public void run() {
            performLongTaskAndReturnRandomInt();
            latch.countDown();
        }
    }

    public static Thread getWorkerThreadWithLatch(CountDownLatch latch) {
        return new Thread(new WorkerRecordRunnableWithLatch(latch));
    }

    public static Thread getWorkerThread() {
        return new Thread(ConcurrencyUtil::performLongTaskAndReturnRandomInt);
    }

    public static Callable<Integer> getWorkerCallable() {
        return ConcurrencyUtil::performLongTaskAndReturnRandomInt;
    }

    /**
     * For threading purposes, this is practically a Callable<Integer> task.
     * It stays busy (sleeping ;) for a random time between 1000 and 5000 ms, and returns that number divided by 100.
     *
     * @return a number between 10 and 50.
     */
    public static int performLongTaskAndReturnRandomInt() {
        int msToSleep = ThreadLocalRandom.current().nextInt(1000, 5000);

        try {
            log.info("{} STARTING to work for {} ms.", Thread.currentThread().getName(), msToSleep);
            TimeUnit.MILLISECONDS.sleep(msToSleep);
        } catch (InterruptedException e) {
            log.error("FAILED to work for {} ms.", msToSleep);
        }
        log.info("{} FINISHED working for {} ms.", Thread.currentThread().getName(), msToSleep);

        return msToSleep / 100;
    }

    public static int productOf(List<Future<Integer>> futureTasks) throws ExecutionException, InterruptedException {
        List<Integer> integerList = new ArrayList<>();
        for (Future<Integer> futureTask : futureTasks) {
            integerList.add(futureTask.get());
        }

        return integerList.stream().reduce(1, (a, b) -> a * b);
    }

}
