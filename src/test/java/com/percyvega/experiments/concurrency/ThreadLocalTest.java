package com.percyvega.experiments.concurrency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ThreadLocalTest {

    private final ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> ThreadLocalRandom.current().nextInt());
    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private final ThreadLocal<SimpleDateFormat> simpledateformatthreadlocal = ThreadLocal.withInitial(() -> new SimpleDateFormat(PATTERN));

    private static final String DATE_AS_STRING = "1999-12-31 23:59:59";
    public static Date DATE_IN_THE_PAST;
    public static Date DATE_IN_THE_FUTURE;

    @BeforeAll
    static void beforeAll() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(1999, 12, 31, 23, 59, 59);
        DATE_IN_THE_PAST = calendar1.getTime();

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2111, 1, 1, 1, 1, 1);
        DATE_IN_THE_FUTURE = calendar2.getTime();
    }

    @Test
    void testingThreads() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            log.info("threadLocal.get(): {}", integerThreadLocal.get());
            assertThat(simpledateformatthreadlocal.get().format(DATE_IN_THE_PAST)).isEqualTo(DATE_AS_STRING); // will fail
        });

        Thread thread2 = new Thread(() -> {
            log.info("threadLocal.get(): {}", integerThreadLocal.get());
            assertThat(simpledateformatthreadlocal.get().format(DATE_IN_THE_PAST)).isEqualTo(DATE_AS_STRING); // will fail
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

}
