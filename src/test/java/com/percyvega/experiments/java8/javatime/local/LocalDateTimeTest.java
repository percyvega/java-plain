package com.percyvega.experiments.java8.javatime.local;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class LocalDateTimeTest {

    @Test
    void test1() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info(localDateTime);
    }

    @Test
    void test2() {
        LocalDateTime localDateTime = LocalDateTime.of(1979, 8, 23, 8, 0, 0, 123);
        assertThat(localDateTime.toString()).isEqualTo("1979-08-23T08:00:00.000000123");
        assertThat(localDateTime.getDayOfWeek()).isEqualTo(DayOfWeek.THURSDAY);
    }

    @Test
    void test3() {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(1979, 8, 23), LocalTime.of(8, 15));
        assertThat(localDateTime.toString()).isEqualTo("1979-08-23T08:15");
    }

    @Test
    void test4() {
        LocalDateTime localDateTime = LocalDateTime.of(1979, 8, 23, 8, 0);
        assertThat(localDateTime.getDayOfWeek()).isEqualTo(DayOfWeek.THURSDAY);
        assertThat(localDateTime.getDayOfMonth()).isEqualTo(23);
        assertThat(localDateTime.getDayOfYear()).isEqualTo(235);
        assertThat(localDateTime.getChronology().toString()).isEqualTo("ISO");
        assertThat(localDateTime.getMonth()).isEqualTo(Month.AUGUST);
        assertThat(localDateTime.get(ChronoField.HOUR_OF_AMPM)).isEqualTo(8);
    }

    @Test
    void test5() {
        LocalDateTime localDateTime = LocalDateTime.of(1979, 8, 23, 8, 0);
        assertThat(localDateTime.get(ChronoField.AMPM_OF_DAY)).isEqualTo(0);
        assertThat(localDateTime.get(ChronoField.CLOCK_HOUR_OF_AMPM)).isEqualTo(8);
        assertThat(localDateTime.get(ChronoField.CLOCK_HOUR_OF_DAY)).isEqualTo(8);
        assertThat(localDateTime.get(ChronoField.ERA)).isEqualTo(1);
        assertThat(localDateTime.getLong(ChronoField.EPOCH_DAY)).isEqualTo(3521);
    }

    @Test
    void test6() {
        LocalDateTime localDateTime = LocalDateTime.of(1979, 8, 23, 8, 0);

        assertThat(localDateTime.plusDays(2).toString()).isEqualTo("1979-08-25T08:00");
        assertThat(localDateTime.plusHours(2).toString()).isEqualTo("1979-08-23T10:00");
        assertThat(localDateTime.plusMinutes(2).toString()).isEqualTo("1979-08-23T08:02");
        assertThat(localDateTime.plusSeconds(2).toString()).isEqualTo("1979-08-23T08:00:02");
        assertThat(localDateTime.plusNanos(2).toString()).isEqualTo("1979-08-23T08:00:00.000000002");
    }

    @Test
    void test7() {
        LocalDateTime localDateTime = LocalDateTime.of(1979, 8, 23, 8, 0);

        assertThat(localDateTime.withYear(2020).toString()).isEqualTo("2020-08-23T08:00");
    }

}
