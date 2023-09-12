package com.percyvega.experiments.java8.oldclassesnewmethods;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MapTest {

    private final static Map<Integer, String> map = new HashMap<>();

    @BeforeEach
    void beforeEach() {
        map.clear();

        assertThat(map.size()).isEqualTo(0);
        assertThat(map.containsKey(23)).isFalse();
    }

    @Test
    void putIfAbsent() {
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "prefix" + i);
        }

        assertThat(map.size()).isEqualTo(10);
        map.forEach((id, val) -> {
            assertThat(id).isLessThan(10);
            assertThat(val).isEqualTo("val" + id);
        });
    }

    @Test
    void computeIfPresent() {
        map.putIfAbsent(23, "Percy");

        assertThat(map.size()).isEqualTo(1);
        assertThat(map.containsKey(23)).isTrue();

        AtomicBoolean entered1 = new AtomicBoolean(false);
        map.computeIfPresent(9, (key, value) -> {
            entered1.set(true);
            return null;
        });
        assertThat(entered1).isFalse();

        AtomicBoolean entered2 = new AtomicBoolean(false);
        map.computeIfPresent(23, (key, value) -> {
            entered2.set(true);
            assertThat(key).isEqualTo(23);
            assertThat(value).isEqualTo("Percy");
            return value;
        });
        assertThat(entered2).isTrue();
    }

    @Test
    void computeIfAbsent() {
        AtomicBoolean entered1 = new AtomicBoolean(false);
        map.computeIfAbsent(1, i -> {
            entered1.set(true);
            return null;
        });
        assertThat(map.get(1)).isNull();
        assertThat(entered1).isTrue();
    }

}
