package com.percyvega.experiments.java8.streams;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class NumericStreamsTest {

    @Test
    void createIntStreams() {
        IntStream.range(1, 9).forEach(log::info);
        IntStream.of(1, 4, 6, 7, 9).forEach(log::info);
        Stream.of(1, 4, 6, 7, 9).forEach(log::info);
        Arrays.stream(new int[]{1, 4, 6, 7, 9}).forEach(log::info);
    }

    @Test
    void mapAndAverage() {
        IntStream.of(1, 2, 4, 6, 9, 11)
                .map(n -> n * n)
                .average()
                .ifPresent(log::info);
    }

    @Test
    void mapToInt() {
        Stream.of(1.5, 2.5, 10.2)
                .mapToInt(Double::intValue)
                .forEach(log::info);
    }

    @Test
    void intStream() {
        assertThat(IntStream.range(10, 13)
                .sum()).isEqualTo(10 + 11 + 12);

        assertThat(IntStream.rangeClosed(10, 13)
                .sum()).isEqualTo(10 + 11 + 12 + 13);

        assertThat(IntStream.generate(new Random()::nextInt)
                .limit(3)
                .count()).isEqualTo(3);

        assertThat(IntStream.iterate(1, (x) -> x + 1)
                .limit(3)
                .sum()).isEqualTo(1 + 2 + 3);

        assertThat(IntStream.of(4)
                .toArray()).isEqualTo(new int[]{4});

        assertThat(IntStream.of(8, 23, 1979)
                .sum()).isEqualTo(8 + 23 + 1979);

        assertThat(IntStream.of(8, 23, 1979)
                .boxed()
                .collect(Collectors.toList())).isEqualTo(Arrays.asList(8, 23, 1979));

        Stream<Integer> integerStream = Stream.of(8, 23, 1979);
        IntStream intStream = integerStream.mapToInt(Integer::intValue);
        intStream.forEach(value -> log.info("Unboxed (from Integer to int): " + value));
    }

    @Test
    void sortIntStream() {
        int[] ints = new int[]{8, 4, 2, 5};

        // sort without streams
        Arrays.sort(ints);
        assertThat(ints[0]).isEqualTo(2);
        assertThat(ints[ints.length - 1]).isEqualTo(8);

        ints = new int[]{8, 4, 2, 5};

        // sort with streams
        ints = Arrays.stream(ints).sorted().toArray();
        assertThat(ints[0]).isEqualTo(2);
        assertThat(ints[ints.length - 1]).isEqualTo(8);

        ints = new int[]{8, 4, 2, 5};

        // sort in reverse order
        ints = Arrays.stream(ints).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        assertThat(ints[0]).isEqualTo(8);
        assertThat(ints[ints.length - 1]).isEqualTo(2);
    }

    @Test
    void longStream() {
        assertThat(LongStream.range(10, 13)
                .sum()).isEqualTo(10 + 11 + 12);

        assertThat(LongStream.rangeClosed(10, 13)
                .sum()).isEqualTo(10 + 11 + 12 + 13);

        assertThat(LongStream.generate(new Random()::nextInt)
                .limit(3)
                .count()).isEqualTo(3);

        assertThat(LongStream.iterate(1, (x) -> x + 1)
                .limit(3)
                .sum()).isEqualTo(1 + 2 + 3);

        assertThat(LongStream.of(4)
                .toArray()).isEqualTo(new long[]{4});

        assertThat(LongStream.of(8, 23, 1979)
                .sum()).isEqualTo(8 + 23 + 1979);

        assertThat(LongStream.of(8, 23, 1979)
                .mapToInt(value -> Integer.parseInt(String.valueOf(value)))
                .boxed()
                .collect(Collectors.toList())).isEqualTo(Arrays.asList(8, 23, 1979));

        Stream<Long> stream = Stream.of(8L, 23L, 1979L);
        LongStream longStream = stream.mapToLong(value -> Long.parseLong(String.valueOf(value)));
        longStream.forEach(log::info);
    }

    @Test
    void doubleStream() {
        assertThat(DoubleStream.generate(new Random()::nextDouble)
                .limit(3)
                .count()).isEqualTo(3);

        assertThat(DoubleStream.iterate(1.5, (x) -> x + 1)
                .limit(3)
                .sum()).isEqualTo(1.5 + 2.5 + 3.5);

        assertThat(DoubleStream.of(4.5)
                .toArray()).isEqualTo(new double[]{4.5});

        assertThat(DoubleStream.of(8.5, 23.5, 1979.5)
                .sum()).isEqualTo(8.5 + 23.5 + 1979.5);

        assertThat(DoubleStream.of(8.5, 23.5, 1979.5)
                .mapToInt(value -> (int) value)
                .boxed()
                .collect(Collectors.toList())).isEqualTo(Arrays.asList(8, 23, 1979));

        Stream<Double> stream = Stream.of(8.5, 23.5, 1979.5);
        IntStream intStream = stream.mapToInt(value -> (int) Math.floor(value));
        intStream.forEach(log::info);
    }

}
