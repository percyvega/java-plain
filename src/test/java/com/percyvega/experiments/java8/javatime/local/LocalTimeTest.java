package com.percyvega.experiments.java8.javatime.local;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class LocalTimeTest {

    @Test
    void test1() {
        LocalTime localTime1 = LocalTime.of(3, 44);
        assertThat(localTime1.toString()).isEqualTo("03:44");

        LocalTime localTime2 = LocalTime.of(3, 44, 23);
        assertThat(localTime2.toString()).isEqualTo("03:44:23");

        LocalTime localTime3 = LocalTime.of(3, 44, 23, 12);
        assertThat(localTime3.toString()).isEqualTo("03:44:23.000000012");

        LocalTime localTime4 = LocalTime.ofNanoOfDay(12);
        assertThat(localTime4.toString()).isEqualTo("00:00:00.000000012");

        LocalTime localTime5 = LocalTime.ofSecondOfDay(12);
        assertThat(localTime5.toString()).isEqualTo("00:00:12");
    }

    @Test
    void test2() {
        LocalTime localTime1 = LocalTime.MAX;
        assertThat(localTime1.toString()).isEqualTo("23:59:59.999999999");

        LocalTime localTime2 = LocalTime.MIDNIGHT;
        assertThat(localTime2.toString()).isEqualTo("00:00");

        LocalTime localTime3 = LocalTime.MIN;
        assertThat(localTime3.toString()).isEqualTo("00:00");
    }

    @Test
    void test3() {
        LocalTime localTime = LocalTime.of(3, 44, 23, 12);

        assertThat(localTime.getHour()).isEqualTo(3);
        assertThat(localTime.getMinute()).isEqualTo(44);
        assertThat(localTime.getSecond()).isEqualTo(23);
        assertThat(localTime.getNano()).isEqualTo(12);
    }

    @Test
    void test4() {
        LocalTime localTime = LocalTime.of(3, 44, 23, 12);

        assertThat(localTime.minusHours(1).toString()).isEqualTo("02:44:23.000000012");
        assertThat(localTime.plusMinutes(32).toString()).isEqualTo("04:16:23.000000012");

        assertThat(localTime.withMinute(2).toString()).isEqualTo("03:02:23.000000012");

        assertThat(localTime.withHour(2).toString()).isEqualTo("02:44:23.000000012");
    }
}
