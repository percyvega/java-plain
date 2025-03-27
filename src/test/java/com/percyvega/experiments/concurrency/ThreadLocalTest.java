package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
public class ThreadLocalTest {

    @Test
    void testThreadLocalRandom() throws InterruptedException {
        ThreadLocal<Integer> threadLocalOfInteger = ThreadLocal.withInitial(() -> ThreadLocalRandom.current().nextInt());

        int threadLocalRandomForMainThread1Value = threadLocalOfInteger.get();
        int threadLocalRandomForMainThread2Value = threadLocalOfInteger.get();

        // threadLocalOfInteger.get() is being called from the same "main" thread twice, so both returned values will be the same.
        assert threadLocalRandomForMainThread1Value == threadLocalRandomForMainThread2Value;

        AtomicInteger threadLocalRandomForThread1 = new AtomicInteger();
        AtomicInteger threadLocalRandomForThread2 = new AtomicInteger();

        // here threadLocalOfInteger.get() is called from 2 different threads, so the values they return are different between them and from the one obtained by "main".
        Thread thread1 = new Thread(() -> {
            threadLocalRandomForThread1.set(threadLocalOfInteger.get());
        });
        Thread thread2 = new Thread(() -> {
            threadLocalRandomForThread2.set(threadLocalOfInteger.get());
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assert threadLocalRandomForThread1.get() != threadLocalRandomForThread2.get();
        assert threadLocalRandomForMainThread1Value != threadLocalRandomForThread1.get();
        assert threadLocalRandomForMainThread1Value != threadLocalRandomForThread2.get();
    }

}
