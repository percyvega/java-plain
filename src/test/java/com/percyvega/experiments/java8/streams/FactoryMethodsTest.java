package com.percyvega.experiments.java8.streams;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class FactoryMethodsTest {

    @Test
    void of() {
        Stream.of("Percy", "Francesca", "Nico", "Isabella")
                .forEach(log::info);
    }

    @Test
    void iterate() {
        Stream<Integer> stream = Stream.iterate(2, x -> x * 2)
                .limit(10);

        assertThat(stream).last().isEqualTo(1024);
    }

    @Test
    void generate() {
        Supplier<Long> longSupplier = System::nanoTime;
        Stream.generate(longSupplier)
                .limit(10)
                .forEach(log::info);
    }

}
