package com.percyvega.experiments.java8.javatime.temporalamount;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class InstantTest {

    @Test
    void test0() {
        Instant now = Instant.now();
        log.info(now);

        Instant min = Instant.MIN;
        assertThat(min.toString()).isEqualTo("-1000000000-01-01T00:00:00Z");

        Instant max = Instant.MAX;
        assertThat(max.toString()).isEqualTo("+1000000000-12-31T23:59:59.999999999Z");
    }

    @Test
    void test1() {
        Instant instant = Instant.parse("1979-08-23T08:37:52.123456789Z");
        assertThat(instant.toString()).isEqualTo("1979-08-23T08:37:52.123456789Z");

        Instant instant1 = Instant.parse("1979-08-23T08:37:52.123456Z");
        assertThat(instant1.toString()).isEqualTo("1979-08-23T08:37:52.123456Z");

        Instant instant2 = Instant.parse("1979-08-23T08:37:52.1234Z");
        assertThat(instant2.toString()).isEqualTo("1979-08-23T08:37:52.123400Z");
    }

}
