package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

@Log4j2
public class ThreadLocalTest {

    private final ThreadLocal<Integer> threadLocal1 = ThreadLocal.withInitial(() -> ThreadLocalRandom.current().nextInt());
    private final ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>() {
        @Override
        protected Integer initialValue() {
//            return new Random().nextInt(); same result, but slower.
            return ThreadLocalRandom.current().nextInt();
        }
    };
    private final ThreadLocal<Integer> threadLocal3 = new ThreadLocal<>();
    private final ThreadLocal<Integer> threadLocal4 = new ThreadLocal<>();
    private final ThreadLocal<Integer> threadLocal5 = new ThreadLocal<>();

    @BeforeEach
    void setUp() {
        threadLocal3.set(ThreadLocalRandom.current().nextInt());
    }

    @Test
    void testingThreads() {
        threadLocal4.set(ThreadLocalRandom.current().nextInt());

        Thread thread1 = new Thread(() -> {
            threadLocal5.set(ThreadLocalRandom.current().nextInt());

            log.info("threadLocal1.get(): {}", threadLocal1.get());
            log.info("threadLocal2.get(): {}", threadLocal2.get());
            log.info("threadLocal3.get(): {}", threadLocal3.get());
            log.info("threadLocal4.get(): {}", threadLocal4.get());
            log.info("threadLocal5.get(): {}", threadLocal5.get());
        });

        Thread thread2 = new Thread(() -> {
            log.info("threadLocal1.get(): {}", threadLocal1.get());
            log.info("threadLocal2.get(): {}", threadLocal2.get());
            log.info("threadLocal3.get(): {}", threadLocal3.get());
            log.info("threadLocal4.get(): {}", threadLocal4.get());
            log.info("threadLocal5.get(): {}", threadLocal5.get());
        });

        Thread thread3 = new Thread(() -> {
            log.info("threadLocal1.get(): {}", threadLocal1.get());
            log.info("threadLocal2.get(): {}", threadLocal2.get());
            log.info("threadLocal3.get(): {}", threadLocal3.get());
            log.info("threadLocal4.get(): {}", threadLocal4.get());
            log.info("threadLocal5.get(): {}", threadLocal5.get());
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
