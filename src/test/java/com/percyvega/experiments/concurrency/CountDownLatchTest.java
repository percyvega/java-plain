package com.percyvega.experiments.concurrency;

import com.percyvega.experiments.concurrency.util.ConcurrencyUtil;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.percyvega.experiments.concurrency.util.ConcurrencyUtil.NUMBER_OF_TASKS;

@Log4j2
public class CountDownLatchTest {

    /**
     * There are 3 Callables being executed simultaneously,
     * but we'll only wait for the two to finish.
     *
     * @throws InterruptedException
     */
    @Test
    void countdownLatchTest() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_TASKS);

        int numberOfFuturesToWaitFor = 2;
        CountDownLatch countDownLatch = new CountDownLatch(numberOfFuturesToWaitFor); // only wait for the first 2

        List<Future<Integer>> futureTasks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            futureTasks.add(executorService.submit(ConcurrencyUtil.getWorkerCallable(countDownLatch)));
        }
        log.info("All {} tasks have been put in the queue.", NUMBER_OF_TASKS);

        countDownLatch.await(); // wait only for the first 2 (out of 3) to finish

        int sum = ConcurrencyUtil.sumOf(futureTasks.stream().filter(Future::isDone).toList());
        log.info("Finished obtaining return values from {} futures. Their sum is {}.", numberOfFuturesToWaitFor, sum);
    }

}
