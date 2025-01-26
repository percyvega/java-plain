package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.percyvega.experiments.concurrency.ConcurrencyUtil.NUMBER_OF_TASKS;
import static com.percyvega.experiments.concurrency.ConcurrencyUtil.THREAD_POOL_SIZE;
import static com.percyvega.experiments.concurrency.ConcurrencyUtil.getWorkerCallable;
import static com.percyvega.experiments.concurrency.ConcurrencyUtil.logTimeSinceStart;

@Log4j2
public class FutureTests {

    // since submit() returns a Future value, if Future get() is called, the main thread will be blocked from terminating execution.
    // submit() puts all NUMBER_OF_TASKS tasks in the executorService's queue, but only THREAD_POOL_SIZE tasks are processed at any point in time.
    @Test
    void submitFutureAndTryToGetValue() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<Future<Integer>> futureTasks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            // submit return immediately with a Future
            futureTasks.add(executorService.submit(ConcurrencyUtil::performLongTaskAndReturnRandomInt));
        }
        log.info("All tasks have been put in the queue.");

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            log.info("Result {}: {}", i + 1, futureTasks.get(i).get()); // blocks!!!!!!!!!!!!!!!!!!!!
        }

        log.info("Finished obtaining return values from futures. Their product is {}.", ConcurrencyUtil.productOf(futureTasks));

        executorService.shutdown();

        logTimeSinceStart(start);
    }

    @Test
    public void submitFutureAndAskIfIsDone() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<Future<Integer>> futureTasks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            futureTasks.add(executorService.submit(getWorkerCallable()));
        }

        while (futureTasks.stream().anyMatch(f -> !f.isDone())) {
            log.info("At least one of the tasks has not finished yet.");
            TimeUnit.SECONDS.sleep(1); // blocks!!!!!!!!!!!!!!!!!!!!
        }

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            log.info("Result {}: {}", i + 1, futureTasks.get(i).get());
        }

        log.info("Finished obtaining return values from futures. Their product is {}.", ConcurrencyUtil.productOf(futureTasks));

        executorService.shutdown();

        logTimeSinceStart(start);
    }

}
