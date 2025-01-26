package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.percyvega.experiments.concurrency.ConcurrencyUtil.NUMBER_OF_TASKS;
import static com.percyvega.experiments.concurrency.ConcurrencyUtil.THREAD_POOL_SIZE;
import static com.percyvega.experiments.concurrency.ConcurrencyUtil.logTimeSinceStart;

@Log4j2
public class SleepyThreads {

    // nothing blocks the main thread from terminating execution, which in this case is immediate.
    // So sleepy threads don't have a chance to finish their tasks.
    @Test
    void mainTriesToReachEndImmediatelyButJoinBlocksIt() throws InterruptedException {
        long start = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_TASKS; i++) {
            Thread workerThread = ConcurrencyUtil.getWorkerThread();
            threads.add(workerThread);
            workerThread.start();
        }

        for (Thread thread : threads) {
            thread.join(); // blocks on the first thread, and then on the next one, and so on.
        }

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            log.info("Name {}: {}", i + 1, threads.get(i).getName());
        }

        logTimeSinceStart(start);
    }

    // since execute() doesn't return anything, the only thing that precludes the main thread from terminating execution is awaitTermination().
    // execute() puts all NUMBER_OF_TASKS tasks in the executorService's queue, but only THREAD_POOL_SIZE tasks are processed at any point in time.
    @Test
    void useExecutorServiceExecute() throws InterruptedException {
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            // execute immediately with a void
            executorService.execute(ConcurrencyUtil::performLongTaskAndReturnRandomInt);
        }
        log.info("All tasks have been put in the queue.");

        executorService.shutdown();
        boolean allTasksInQueueCompletedWork = executorService.awaitTermination(3, TimeUnit.SECONDS); // block to wait only 3 seconds!!!!!!!!!!!!!!!!!!
        log.info("All queued tasks finished processing before termination? {}", allTasksInQueueCompletedWork);

        logTimeSinceStart(start);
    }

}
