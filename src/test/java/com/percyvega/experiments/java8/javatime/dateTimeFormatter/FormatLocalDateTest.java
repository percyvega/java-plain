package com.percyvega.experiments.java8.javatime.dateTimeFormatter;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class FormatLocalDateTest {

    @Test
    void localDate_parse() {
        LocalDate localDate1 = LocalDate.parse("2020-12-31");
        assertThat(localDate1.toString()).isEqualTo("2020-12-31");

        LocalDate localDate2 = LocalDate.parse("2020-12-31", DateTimeFormatter.ISO_DATE);
        assertThat(localDate2.toString()).isEqualTo("2020-12-31");

        LocalDate localDate3 = LocalDate.parse("2020-12-31", DateTimeFormatter.ISO_LOCAL_DATE);
        assertThat(localDate3.toString()).isEqualTo("2020-12-31");

        assertThat(localDate3.format(DateTimeFormatter.BASIC_ISO_DATE)).isEqualTo("20201231");

        LocalDate localDate4 = LocalDate.parse("20201231", DateTimeFormatter.BASIC_ISO_DATE);
        assertThat(localDate4.toString()).isEqualTo("2020-12-31");
    }

    @Test
    void localDate__format() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("LLL d, yyyy");

        LocalDate localDate1 = LocalDate.parse("May 6, 2020", dateTimeFormatter);
        assertThat(localDate1.toString()).isEqualTo("2020-05-06");
        assertThat(localDate1.toString()).isNotEqualTo("May 6, 2020");
        assertThat(localDate1.format(dateTimeFormatter)).isEqualTo("May 6, 2020");

        LocalDate localDate2 = LocalDate.parse("Dec 25, 2020", dateTimeFormatter);
        assertThat(localDate2.toString()).isEqualTo("2020-12-25");
        assertThat(localDate2.toString()).isNotEqualTo("Dec 25, 2020");
        assertThat(localDate2.format(dateTimeFormatter)).isEqualTo("Dec 25, 2020");
    }
}
