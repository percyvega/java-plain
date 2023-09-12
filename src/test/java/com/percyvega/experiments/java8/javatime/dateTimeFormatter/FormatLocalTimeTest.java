package com.percyvega.experiments.java8.javatime.dateTimeFormatter;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class FormatLocalTimeTest {

    @Test
    void localTime_parse() {
        LocalTime localTime1 = LocalTime.parse("08:00");
        assertThat(localTime1.toString()).isEqualTo("08:00");

        LocalTime localTime2 = LocalTime.parse("08:00:00");
        assertThat(localTime2.toString()).isEqualTo("08:00");

        LocalTime localTime3 = LocalTime.parse("08:00:01");
        assertThat(localTime3.toString()).isEqualTo("08:00:01");

        LocalTime localTime4 = LocalTime.parse("08:00", DateTimeFormatter.ISO_TIME);
        assertThat(localTime4.toString()).isEqualTo("08:00");

        LocalTime localTime5 = LocalTime.parse("08:00", DateTimeFormatter.ISO_LOCAL_TIME);
        assertThat(localTime5.toString()).isEqualTo("08:00");
    }

    @Test
    void localTime_parse_using_ofPattern() {
        LocalTime localTime1 = LocalTime.parse("23:59:59.999");
        assertThat(localTime1.toString()).isEqualTo("23:59:59.999");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh|mm|ss.SSS a");

        LocalTime localTime2 = LocalTime.parse("11|59|59.999 PM", dateTimeFormatter);
        assertThat(localTime2.toString()).isEqualTo("23:59:59.999");
    }

    @Test
    void localTime__format() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh|mm|ss.SSS a");

        LocalTime localTime1 = LocalTime.parse("11|59|59.999 PM", dateTimeFormatter);
        assertThat(localTime1.format(dateTimeFormatter)).isEqualTo("11|59|59.999 PM");
    }

}
