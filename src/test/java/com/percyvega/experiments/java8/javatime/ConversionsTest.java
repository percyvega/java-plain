package com.percyvega.experiments.java8.javatime;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class ConversionsTest {

    LocalTime localTime = LocalTime.now();
    LocalDate localDate = LocalDate.now();
    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

    @Test
    void localDate_to_localDateTime() {
        LocalDateTime actual = localDate.atTime(localTime);
        assertThat(actual).isEqualTo(localDateTime);
        log.info(actual);
    }

    @Test
    void localTime_to_localDateTime() {
        LocalDateTime actual = localTime.atDate(localDate);
        assertThat(actual).isEqualTo(localDateTime);
        log.info(actual);
    }

    @Test
    void localDateTime_to_localDate_and_localTime() {
        assertThat(localDateTime.toLocalDate()).isEqualTo(localDate);
        assertThat(localDateTime.toLocalTime()).isEqualTo(localTime);
    }

    @Test
    void from_Date() {
        Date date = new Date(1582000000000L);

        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime localDateTime2 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime localTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        assertThat(localDateTime1).isEqualTo(localDateTime2);
        assertThat(localDateTime1.toLocalDate()).isEqualTo(localDate);
        assertThat(localDateTime1.toLocalTime()).isEqualTo(localTime);
    }

    @Test
    void to_Date() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZoneOffset zoneOffset = zonedDateTime.getOffset();

        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        Instant instant = localDateTime.toInstant(zoneOffset);
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();

        Date date1 = Date.from(localDateTime.toInstant(zoneOffset));
        Date date2 = Date.from(instant);
        Date date3 = Date.from(localDate.atTime(localTime).toInstant(zoneOffset));
        Date date4 = Date.from(localTime.atDate(LocalDate.now()).toInstant(zoneOffset));

        assertThat(date1).isEqualTo(date2).isEqualTo(date3).isEqualTo(date4);
    }

}
