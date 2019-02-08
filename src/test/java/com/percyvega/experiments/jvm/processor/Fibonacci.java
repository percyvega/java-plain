package com.percyvega.experiments.jvm.processor;

import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Usually takes 100-105 seconds to complete.
 */
public class Fibonacci {

    public static Integer HIGHEST_NUM = 37;
    public static int NUM_THREADS = 30;

    public static BigInteger fib(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) == -1 || n.compareTo(BigInteger.ONE) == 0)
            return n;
        else
            return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.ONE).subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        System.out.println("Starting main at " + start);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int j = 0; j < NUM_THREADS; j++) {

            final int ID = j;
            executorService.submit((Runnable) () -> {
                long lastPrinted = 0;
                for (int i = 0; i < HIGHEST_NUM; i++) {
                    BigInteger fib = fib(new BigInteger(String.valueOf(i)));

                    if ((System.currentTimeMillis() - lastPrinted) > 1000) {
                        lastPrinted = System.currentTimeMillis();
                        System.out.println(new Date() + ", thread=" + ID + ", fib(" + i + ")=" + fib);
                    }
                }
            });

        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);
        System.out.println("Finishing main after " + (System.currentTimeMillis() - start) / 1000f + " seconds.");
    }

}
