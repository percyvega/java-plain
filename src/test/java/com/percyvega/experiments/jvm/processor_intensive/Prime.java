package com.percyvega.experiments.jvm.processor_intensive;

import lombok.extern.log4j.Log4j2;

import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Usually takes 70-75 seconds to complete.
 */
@Log4j2
public class Prime {

    public static Integer HIGHEST_NUM = 40000;
    public static int NUM_THREADS = 30;

    public static boolean isPrime(BigInteger n) {
        BigInteger counter = BigInteger.ONE.add(BigInteger.ONE);
        boolean isPrime = true;
        while (counter.compareTo(n) == -1) {
            if (n.remainder(counter).compareTo(BigInteger.ZERO) == 0) {
                isPrime = false;
                break;
            }
            counter = counter.add(BigInteger.ONE);
        }
        return isPrime;
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        log.info("Starting main at " + start);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int j = 0; j < NUM_THREADS; j++) {

            final int ID = j;
            executorService.submit(() -> {
                long lastPrinted = 0;
                for (int i = 0; i < HIGHEST_NUM; i++) {
                    boolean isPrime = isPrime(new BigInteger(Integer.toString(i)));

                    if ((System.currentTimeMillis() - lastPrinted) > 1000) {
                        lastPrinted = System.currentTimeMillis();
                        log.info(new Date() + ", thread=" + ID + ", isPrime(" + i + ")=" + isPrime);
                    }

                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);
        log.info("Finishing main after " + (System.currentTimeMillis() - start) / 1000f + " seconds.");
    }

}
