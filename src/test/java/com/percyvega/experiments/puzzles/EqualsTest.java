package com.percyvega.experiments.puzzles;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The equals method evaluates logical values, while == evaluates if both references point to the same object.
 */
@Log4j2
public class EqualsTest {

    @Test
    void testIntegerEquality() {
        for (int i = -130; i <= 130; i++) {
            Integer integer1 = i;
            Integer integer2 = i;

            if (-128 <= i && i <= 127) {
                assertThat(integer1 == integer2).isTrue();
            } else {
                // -130, -129, 128, 129, 130
                assertThat(integer1 != integer2).isTrue();
            }

            assertThat(integer1.equals(integer2)).isTrue();
        }
    }

    @Test
    void testObjectEquality() {
        for (int i = -130; i <= 130; i++) {
            Map.Entry<Integer, String> entry1 = new AbstractMap.SimpleEntry<>(i, Integer.toString(i));
            Map.Entry<Integer, String> entry2 = new AbstractMap.SimpleEntry<>(i, Integer.toString(i));

            assertThat(entry1.equals(entry2)).isTrue();
            assertThat(entry1 != entry2).isTrue();
        }
    }

}
