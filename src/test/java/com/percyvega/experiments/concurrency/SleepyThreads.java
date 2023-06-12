package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Log4j2
public class SleepyThreads {

    public static final int NUMBER_OF_THREADS = 10;
    public static final int THREAD_POOL_SIZE = 4;

    // nothing precludes the main thread from terminating execution
    @Test
    void useThreads() {
        long start = System.currentTimeMillis();

        for (int i = 1; i <= NUMBER_OF_THREADS; i++) {
            new Thread(SleepyThreads::sleepFor).start();
        }

        log.info("Finishing after " + (System.currentTimeMillis() - start) / 1000f + " seconds.");
    }

    // since execute() doesn't return anything,
    //  only awaitTermination() precludes the main thread from terminating execution
    @Test
    void useExecutorServiceExecute() throws InterruptedException {
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            // execute immediately returns void
            // execute will put in the executorService's queue all 10 threads,
            //  but those to be processed are limited by the thread-pool size
            executorService.execute(SleepyThreads::sleepFor);
        }

        log.info("Looping results in strict order of tasks started.");

        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        log.info("Finishing after " + (System.currentTimeMillis() - start) / 1000f + " seconds.");
    }

    // since submit()'s return value (an int in this case) is read,
    //  the main thread is precluded from terminating execution
    @Test
    void useExecutorServiceSubmit() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<Future<String>> futureTasks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            // submit immediately returns a Future
            // submit puts in the executorService's queue all 10 threads,
            //  but those to be processed are limited by the thread-pool size
            futureTasks.add(executorService.submit(SleepyThreads::sleepFor));
        }

        log.info("Looping results in strict order of tasks started. get() is blocking until that task produces a result.");

        for (int i = 0; i < NUMBER_OF_THREADS; i++)
            log.info(futureTasks.get(i).get());

        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        log.info("Finishing after " + (System.currentTimeMillis() - start) / 1000f + " seconds.");
    }

    // sleeps between 1 and 10 seconds and returns the number of ms it slept
    private static String sleepFor() {
        String name = Thread.currentThread().getName();
        int msToSleep = ThreadLocalRandom.current().nextInt(1000, 10000);
        log.info(name + "\t" + "About to sleep for " + msToSleep + " ms.");

        try {
            Thread.sleep(msToSleep);
            log.info(name + "\t" + "Done sleeping for " + msToSleep + " ms.");
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info(name + "\t" + "Failed to sleep for " + msToSleep + " ms.");
        }
        return name + "'s future result: " + msToSleep;
    }


}

