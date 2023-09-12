package com.percyvega.experiments.java8.javatime.dateTimeFormatter;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class FormatLocalDateTimeTest {

    @Test
    void localDateTime_parse() {
        String localDateTimeString1 = "2020-03-01T14:42:59";
        LocalDateTime localDateTime1 = LocalDateTime.parse(localDateTimeString1);
        assertThat(localDateTime1.toString()).isEqualTo(localDateTimeString1);

        String localDateTimeString2 = "2020-03-01T14:42:00";
        LocalDateTime localDateTime2 = LocalDateTime.parse(localDateTimeString2);
        assertThat(localDateTime2.toString()).isEqualTo("2020-03-01T14:42");

        String localDateTimeString3 = "2020-03-01T14:42:59.333";
        LocalDateTime localDateTime3 = LocalDateTime.parse(localDateTimeString3);
        assertThat(localDateTime3.toString()).isEqualTo(localDateTimeString3);

        String localDateTimeString4 = "2020-03-01T14:42:59.33300";
        LocalDateTime localDateTime4 = LocalDateTime.parse(localDateTimeString4);
        assertThat(localDateTime4.toString()).isEqualTo("2020-03-01T14:42:59.333");

        String localDateTimeString5 = "2020-03-01T14:42:59";
        LocalDateTime localDateTime5 = LocalDateTime.parse(localDateTimeString5, DateTimeFormatter.ISO_DATE_TIME);
        assertThat(localDateTime5.toString()).isEqualTo(localDateTimeString5);
        LocalDateTime localDateTime6 = LocalDateTime.parse(localDateTimeString5, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        assertThat(localDateTime6.toString()).isEqualTo(localDateTimeString5);
    }

    @Test
    void localDateTime_parse_using_ofPattern() {
        String localDateTimeString = "2020-03-01T14:42:59";

        LocalDateTime localDateTime1 = LocalDateTime.parse(localDateTimeString);
        assertThat(localDateTime1.toString()).isEqualTo(localDateTimeString);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime localDateTime2 = LocalDateTime.parse(localDateTimeString, dateTimeFormatter);
        assertThat(localDateTime2.toString()).isEqualTo(localDateTimeString);

        String localDateTimeString2 = "2020-Aug-23|14|42|59";
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-LLL-dd'|'HH|mm|ss");
        LocalDateTime localDateTime3 = LocalDateTime.parse(localDateTimeString2, dateTimeFormatter2);
        assertThat(localDateTime3.toString()).isEqualTo("2020-08-23T14:42:59");
    }

    @Test
    void localDateTime__format() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-LLL-dd'|'HH|mm|ss");

        LocalDateTime localDateTime = LocalDateTime.parse("2020-08-23T14:42:59.333");

        assertThat(localDateTime.format(dateTimeFormatter)).isEqualTo("2020-Aug-23|14|42|59");
    }

}
