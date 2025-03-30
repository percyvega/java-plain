package com.percyvega.experiments.concurrency;

import com.percyvega.experiments.concurrency.util.ConcurrencyUtil;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.percyvega.experiments.concurrency.util.ConcurrencyUtil.NUMBER_OF_TASKS;


@Log4j2
public class ThreadTests {

    /**
     * Nothing blocks the main thread from terminating execution, which in this case is immediate.
     * So sleepy threads don't have a chance to finish their tasks.
     *
     * @throws InterruptedException when a thread is interrupted
     */
    @Test
    void threadUseOfJoinToWaitTest() throws InterruptedException {
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

        log.info("Finishing main after {} seconds.", (System.currentTimeMillis() - start) / 1000f);
    }

    @Test
    void test_interrupt() {
    }

    @Test
    void test_notify() {
    }

}
