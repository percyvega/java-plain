package com.percyvega.experiments.java8.javatime.local;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class LocalDateTest {

    @Test
    void localDateIsImmutable() {
        LocalDate now = LocalDate.now();
        String nowString = now.toString();

        now.plus(2, ChronoUnit.DAYS);
        LocalDate now2 = LocalDate.from(now);
        String now2String = now2.toString();

        LocalDate nowPlus2Days = now.plus(2, ChronoUnit.DAYS);
        String nowPlus2DaysString = nowPlus2Days.toString();

        assertThat(now).isEqualTo(now2);
        assertThat(nowString).isEqualTo(now2String);
        assertThat(now).isNotEqualTo(nowPlus2Days);
        assertThat(nowString).isNotEqualTo(nowPlus2DaysString);
    }

    @Test
    void test2() {
        log.info(LocalDate.now(Clock.systemUTC()));
        log.info(LocalDate.now(Clock.system(ZoneId.of("UTC-12"))));

        log.info(LocalDate.now(ZoneId.of("UTC")));
        log.info(LocalDate.now(ZoneId.of("UTC-12")));
    }

    @Test
    void test3() {
        assertThat(LocalDate.of(1979, 8, 23).toString()).isEqualTo("1979-08-23");
        assertThat(LocalDate.of(1986, Month.JANUARY, 19).toString()).isEqualTo("1986-01-19");
    }

    @Test
    void test4() {
        LocalDate localDate = LocalDate.ofYearDay(1979, 235);
        assertThat(localDate.toString()).isEqualTo("1979-08-23");
        assertThat(localDate.getEra().toString()).isEqualTo("CE");
        assertThat(localDate.getChronology().toString()).isEqualTo("ISO");
        assertThat(localDate.getDayOfWeek().toString()).isEqualTo("THURSDAY");
        assertThat(localDate.get(ChronoField.DAY_OF_WEEK)).isEqualTo(4);
    }

    @Test
    void test5() {
        LocalDate localDate = LocalDate.of(1979, 8, 23);
        assertThat(localDate.toString()).isEqualTo("1979-08-23");

        assertThat(localDate.plusDays(-1).toString()).isEqualTo("1979-08-22");
        assertThat(localDate.minusWeeks(1).toString()).isEqualTo("1979-08-16");
        assertThat(localDate.minusMonths(1).toString()).isEqualTo("1979-07-23");
        assertThat(localDate.plusYears(-1).toString()).isEqualTo("1978-08-23");

        assertThat(localDate.withYear(2020).toString()).isEqualTo("2020-08-23");
        assertThat(localDate.with(ChronoField.DAY_OF_MONTH, 1).toString()).isEqualTo("1979-08-01");
        assertThat(localDate.with(TemporalAdjusters.firstDayOfNextMonth()).toString()).isEqualTo("1979-09-01");

        assertThat(localDate.plus(3, ChronoUnit.DAYS).toString()).isEqualTo("1979-08-26");
    }

    @Test
    void test6() {
        LocalDate today = LocalDate.of(1979, 8, 23);
        LocalDate yesterday = today.minusDays(1);

        assertThat(today.isEqual(yesterday)).isFalse();
        assertThat(today.isBefore(yesterday)).isFalse();
        assertThat(today.isAfter(yesterday)).isTrue();
    }

}
