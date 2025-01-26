package com.percyvega.experiments.java8.javatime.temporalamount;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class DurationTest {

    @Test
    void test0() {
        Duration duration = Duration.of(5, ChronoUnit.DAYS);
        assertThat(duration.toHours()).isEqualTo(5 * 24);

        Duration duration1 = Duration.ofDays(10);
        assertThat(duration1.toHours()).isEqualTo(10 * 24);

        Duration duration2 = Duration.ofHours(10);
        assertThat(duration2.toHours()).isEqualTo(10);

        Duration duration3 = Duration.ofMinutes(10);
        assertThat(duration3.toHours()).isEqualTo(0);
        assertThat(duration3.toMinutes()).isEqualTo(10);
    }

    @DisplayName("This test will fail when there are less than 12 minutes until midnight")
    @Test
    void durationBetweenTwoLocalTimes() {
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = localTime1.plusMinutes(12);

        Duration duration1 = Duration.between(localTime1, localTime2);
        Duration duration2 = Duration.between(localTime2, localTime1);

        assertThat(duration1.toMinutes()).isIn(12L, -1428L);
        assertThat(duration2.toMinutes()).isIn(-12L, 1428L);
    }

    @Test
    void durationBetweenTwoInstants() {
        Instant now1 = Instant.parse("1979-08-23T08:37:52.123456789Z");
        Instant now2 = Instant.parse("1979-08-23T08:37:52.12Z");

        Duration duration = Duration.between(now2, now1);
        assertThat(duration.toMillis()).isEqualTo(3);
        assertThat(duration.toNanos()).isEqualTo(3456789);
    }
}
