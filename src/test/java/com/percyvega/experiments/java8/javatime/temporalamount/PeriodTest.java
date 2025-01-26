package com.percyvega.experiments.java8.javatime.temporalamount;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class PeriodTest {

    @Test
    void test0() {
        Period period = Period.ZERO;
        assertThat(period.toTotalMonths()).isEqualTo(0);
    }

    @Test
    void test1() {
        Period period = Period.of(1, 21, 41);
        assertThat(period.getYears()).isEqualTo(1);
        assertThat(period.getMonths()).isEqualTo(21);
        assertThat(period.getDays()).isEqualTo(41);

        Period period1 = Period.ofYears(5);
        assertThat(period1.getYears()).isEqualTo(5);
        assertThat(period1.getMonths()).isEqualTo(0);
        assertThat(period1.getDays()).isEqualTo(0);

        Period period2 = period1.withMonths(13);
        assertThat(period2.getYears()).isEqualTo(5);
        assertThat(period2.getMonths()).isEqualTo(13);
        assertThat(period2.getDays()).isEqualTo(0);

        Period period3 = period2.withDays(42);
        assertThat(period3.getYears()).isEqualTo(5);
        assertThat(period3.getMonths()).isEqualTo(13);
        assertThat(period3.getDays()).isEqualTo(42);
    }

    @Test
    void test2() {
        LocalDate today = LocalDate.now();
        LocalDate someFutureLocalDate = today
                .plusYears(2)
                .plusMonths(1)
                .plusDays(37);

        Period period = Period.between(today, someFutureLocalDate);
        assertThat(period.getYears()).isEqualTo(2);
        assertThat(period.getMonths()).isEqualTo(2);
//        assertThat(period.getDays()).isEqualTo(6); // we can't be sure of this because number of days change from month to month

        Period period1 = Period.between(someFutureLocalDate, today);
        assertThat(period1.getYears()).isEqualTo(-2);
        assertThat(period1.getMonths()).isEqualTo(-2);
//        assertThat(period1.getDays()).isEqualTo(-6); // we can't be sure of this because number of days change from month to month
    }

    @Test
    void test3() {
        Period period = Period.of(1, 21, 41);
        assertThat(period.getYears()).isEqualTo(1);
        assertThat(period.getMonths()).isEqualTo(21);
        assertThat(period.getDays()).isEqualTo(41);

        assertThat(period.toTotalMonths()).isEqualTo(12 + 21);
    }

}
