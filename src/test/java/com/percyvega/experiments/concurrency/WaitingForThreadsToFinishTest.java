package com.percyvega.experiments.concurrency;

import com.percyvega.experiments.concurrency.util.ConcurrencyUtil;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.percyvega.experiments.concurrency.util.ConcurrencyUtil.NUMBER_OF_TASKS;
import static com.percyvega.experiments.concurrency.util.ConcurrencyUtil.THREAD_POOL_SIZE;


@Log4j2
public class WaitingForThreadsToFinishTest {

    /**
     * Nothing blocks the main thread from terminating execution, which in this case is immediate.
     * So sleepy threads don't have a chance to finish their tasks.
     *
     * @throws InterruptedException when a thread is interrupted
     */
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
            log.info("Name {}: {}", i, threads.get(i).getName());
        }
    }

    /**
     * Since executorService's execute() doesn't return anything, the only thing that precludes the main thread from terminating execution is awaitTermination().
     * execute() puts all NUMBER_OF_TASKS tasks in the executorService's queue, but only THREAD_POOL_SIZE tasks are processed at any point in time.
     *
     * @throws InterruptedException when a thread is interrupted
     */
    @Test
    void useExecutorServiceExecute() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            // execute returns void
            executorService.execute(ConcurrencyUtil::performLongTaskAndReturnRandomInt);
        }
        log.info("All {} tasks have been put in the queue.", NUMBER_OF_TASKS);

        executorService.shutdown();
        boolean allTasksInQueueCompletedWork = executorService.awaitTermination(5, TimeUnit.SECONDS); // waits up to 5 seconds for threads to finish
        log.info("All {} queued tasks finished processing before termination? {}", NUMBER_OF_TASKS, allTasksInQueueCompletedWork);
    }

}
