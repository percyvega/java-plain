package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ThreadLocalTest {

    @Test
    void testThreadLocalRandom() throws InterruptedException {
        ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> ThreadLocalRandom.current().nextInt());

        int threadLocalRandomForMainThread1 = integerThreadLocal.get();
        int threadLocalRandomForMainThread2 = integerThreadLocal.get();

        // integerThreadLocal.get() is being called from the same "main" thread, so it will return the same number.
        assertThat(threadLocalRandomForMainThread1).isEqualTo(threadLocalRandomForMainThread2);

        AtomicInteger threadLocalRandomForThread1 = new AtomicInteger();
        Thread thread1 = new Thread(() -> {
            threadLocalRandomForThread1.set(integerThreadLocal.get());
        });

        AtomicInteger threadLocalRandomForThread2 = new AtomicInteger();
        Thread thread2 = new Thread(() -> {
            threadLocalRandomForThread2.set(integerThreadLocal.get());
        });

        // here integerThreadLocal.get() is called from different threads, so it returns a different number
        assertThat(threadLocalRandomForMainThread1).isNotEqualTo(threadLocalRandomForThread1);
        assertThat(threadLocalRandomForMainThread1).isNotEqualTo(threadLocalRandomForThread2);
        assertThat(threadLocalRandomForThread1).isNotEqualTo(threadLocalRandomForThread2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }

}
