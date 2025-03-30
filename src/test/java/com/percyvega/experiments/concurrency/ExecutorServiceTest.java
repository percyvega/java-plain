package com.percyvega.experiments.concurrency;

import com.percyvega.experiments.concurrency.util.ConcurrencyUtil;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.percyvega.experiments.concurrency.util.ConcurrencyUtil.NUMBER_OF_TASKS;
import static com.percyvega.experiments.concurrency.util.ConcurrencyUtil.THREAD_POOL_SIZE;

@Log4j2
public class ExecutorServiceTest {

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

    /**
     * submit() puts all NUMBER_OF_TASKS tasks in the executorService's queue, but only THREAD_POOL_SIZE tasks are processed at any point in time.
     * Since submit() returns a Future value, if Future get() is called, the main thread will be blocked from terminating execution.
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @Test
    void submitFutureAndTryToGetValue() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<Future<Integer>> futureTasks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            // submit returns a Future immediately
            futureTasks.add(executorService.submit(ConcurrencyUtil::performLongTaskAndReturnRandomInt));
        }
        log.info("All tasks have been put in the queue.");

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            log.info("Result {}: {}", i + 1, futureTasks.get(i).get()); // get() blocks until task is completed
        }

        log.info("Finished obtaining return values from futures. Their sum is {}.", ConcurrencyUtil.sumOf(futureTasks));

        executorService.shutdown();
    }

    @Test
    public void submitFutureAndAskIfIsDone() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<Future<Integer>> futureTasks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            // submit returns a Future immediately
            futureTasks.add(executorService.submit(ConcurrencyUtil.getWorkerCallable()));
        }
        log.info("All tasks have been put in the queue.");

        while (futureTasks.stream().anyMatch(f -> !f.isDone())) {
            log.info("At least one of the tasks has not finished yet.");
            TimeUnit.SECONDS.sleep(1); // wait for a second before asking again
        }

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            log.info("Result {}: {}", i + 1, futureTasks.get(i).get()); // get() blocks until task is completed
        }

        log.info("Finished obtaining return values from futures. Their sum is {}.", ConcurrencyUtil.sumOf(futureTasks));

        executorService.shutdown();
    }

}
