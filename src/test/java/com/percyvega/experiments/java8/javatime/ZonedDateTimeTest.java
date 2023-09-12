package com.percyvega.experiments.java8.javatime;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Date;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ZonedDateTimeTest {

    @Test
    void zonedDateTimeTest() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        String localDateTimeString = zonedDateTime.toLocalDateTime().toString();
        assertThat(localDateTimeString).isEqualTo(zonedDateTime.toLocalDate() + "T" + zonedDateTime.toLocalTime());

        String offsetString = zonedDateTime.getOffset().toString();
        String zoneString = zonedDateTime.getZone().toString();
        assertThat(localDateTimeString + offsetString + "[" + zoneString + "]");
        assertThat(zonedDateTime.toOffsetDateTime()).isEqualTo(localDateTimeString + offsetString);

        assertThat(zonedDateTime.getChronology().toString()).isEqualTo("ISO");
    }

    @Test
    void zoneIdTest() {
        assertThat(ZoneId.systemDefault().toString()).isEqualTo("America/New_York");
        assertThat(ZoneId.systemDefault().getRules().getTransitions().size()).isEqualTo(177);

        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        assertThat(zoneId.toString()).isEqualTo("America/Los_Angeles");
        assertThat(zoneId.normalized().toString()).isEqualTo("America/Los_Angeles");
        assertThat(zoneId.getId()).isEqualTo("America/Los_Angeles");

        assertThat(ZoneId.getAvailableZoneIds().size()).isGreaterThanOrEqualTo(600);

        LocalDateTime nyLDT = LocalDateTime.now(ZoneId.of("America/New_York"));
        LocalDateTime laLDT = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        assertThat(nyLDT.getHour()).isEqualTo((laLDT.getHour() + 3) % 24);
        assertThat(nyLDT.getMinute()).isEqualTo(laLDT.getMinute());
        assertThat(nyLDT.getSecond()).isEqualTo(laLDT.getSecond());

        ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime la = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        assertThat(ny.getHour()).isEqualTo((la.getHour() + 3) % 24);
        assertThat(ny.getMinute()).isEqualTo(la.getMinute());
        assertThat(ny.getSecond()).isEqualTo(la.getSecond());

        // Immutable! Once you created it you can't change the values, only assign a Zone to produce a new ZonedDateTime object
        ZonedDateTime zonedDateTime1 = LocalDateTime.now().atZone(ZoneId.of("America/New_York"));
        ZonedDateTime zonedDateTime2 = LocalDateTime.now().atZone(ZoneId.of("America/Los_Angeles"));
        assertThat(zonedDateTime1.getHour()).isEqualTo((zonedDateTime2.getHour()));
        assertThat(zonedDateTime1.getMinute()).isEqualTo(zonedDateTime2.getMinute());
        assertThat(zonedDateTime1.getSecond()).isEqualTo(zonedDateTime2.getSecond());
    }

    @Test
    void zoneOffsetTest() {
        assertThat(ZoneOffset.systemDefault().toString()).isEqualTo("America/New_York");

        assertThat(ZoneOffset.getAvailableZoneIds().size()).isGreaterThanOrEqualTo(600);
    }

    @Test
    void offsetDateTimeTest() {
        ZoneId nyZone = ZoneId.of("America/New_York");
        boolean inDaylightTime = TimeZone.getTimeZone(nyZone).inDaylightTime(new Date());

        ZonedDateTime zonedDateTime = ZonedDateTime.now(nyZone);

        LocalDateTime now = zonedDateTime.toLocalDateTime();
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(inDaylightTime ? -4 : -5));

        assertThat(offsetDateTime.toString()).isEqualTo(zonedDateTime.toLocalDateTime().toString() + zonedDateTime.getOffset());
    }

}
