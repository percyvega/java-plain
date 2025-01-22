package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Log4j2
public class SleepyThreads {

    public static final int NUMBER_OF_TASKS = 10;
    public static final int THREAD_POOL_SIZE = 4;

    // nothing blocks the main thread from terminating execution, which in this case is immediate.
    // So sleepy threads don't have a chance to finish their tasks.
    @Test
    void mainReachesEndImmediatelyButThreadsAreStillRunning() {
        long start = System.currentTimeMillis();

        for (int i = 1; i <= NUMBER_OF_TASKS; i++) {
            new Thread(SleepyThreads::performTask).start();
        }

        logTimeSinceStart(start);
    }

    // since execute() doesn't return anything, the only thing that precludes the main thread from terminating execution is awaitTermination().
    // execute() puts all NUMBER_OF_TASKS tasks in the executorService's queue, but only THREAD_POOL_SIZE tasks are processed at any point in time.
    @Disabled // otherwise running all tests will take a long time
    @Test
    void useExecutorServiceExecute() throws InterruptedException {
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            // execute immediately returns void
            executorService.execute(SleepyThreads::performTask);
        }
        log.info("All tasks have been put in the queue.");

        executorService.shutdown();
        boolean allTasksInQueueCompletedWork = executorService.awaitTermination(4, TimeUnit.SECONDS);
        log.info("All tasks queued finished processing before termination? {}", allTasksInQueueCompletedWork);

        logTimeSinceStart(start);
    }

    // since submit() returns a Future value, if Future get() is called, the main thread will be blocked from terminating execution.
    // submit() puts all NUMBER_OF_TASKS tasks in the executorService's queue, but only THREAD_POOL_SIZE tasks are processed at any point in time.
    @Disabled
    @Test
    void useExecutorServiceSubmit() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<Future<String>> futureTasks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            // submit immediately returns a Future
            futureTasks.add(executorService.submit(SleepyThreads::performTask));
        }
        log.info("All tasks have been put in the queue.");

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            log.info(futureTasks.get(i).get()); // blocks!!!!!
        }
        log.info("Finished obtaining return values from futures.");

        executorService.shutdown();
        boolean allTasksInQueueCompletedWork = executorService.awaitTermination(4, TimeUnit.SECONDS); // always true, because it was blocked to obtain results (which implies that all tasks finished).
        log.info("All tasks queued finished processing before termination? {}", allTasksInQueueCompletedWork);

        logTimeSinceStart(start);
    }

    // stays busy between 1 and 10 seconds and returns the number of ms it stayed busy
    private static String performTask() {
        String name = Thread.currentThread().getName();
        int msToSleep = ThreadLocalRandom.current().nextInt(1000, 10000);
        log.info("{}\tAbout to sleep for {} ms.", name, msToSleep);

        try {
            Thread.sleep(msToSleep);
            log.info("{}\tDone sleeping for {} ms.", name, msToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info("{}\tFailed to sleep for {} ms.", name, msToSleep);
        }
        return name + "'s future result: " + msToSleep;
    }

    private static void logTimeSinceStart(long startTimeMillis) {
        log.info("Reached end after {} seconds.", (System.currentTimeMillis() - startTimeMillis) / 1000f);
    }
}

