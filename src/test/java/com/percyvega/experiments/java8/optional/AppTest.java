package com.percyvega.experiments.java8.optional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AppTest {

    @Test
    public void testFindLongest1() {
        List<String> strings = null;

        Optional<String> stringOptional = App.findLongest(strings);
        assertFalse(stringOptional.isPresent());
    }

    @Test
    public void testFindLongest2() {
        List<String> strings = Arrays.asList();

        Optional<String> stringOptional = App.findLongest(strings);
        assertFalse(stringOptional.isPresent());
    }

    @Test
    public void testFindLongest3() {
        List<String> strings = Arrays.asList("1234");

        Optional<String> stringOptional = App.findLongest(strings);
        assertEquals(stringOptional.get(), "1234");
    }

    @Test
    public void testFindLongest4() {
        List<String> strings = Arrays.asList("1234", "12", "123456");

        Optional<String> stringOptional = App.findLongest(strings);
        assertEquals(stringOptional.get(), "123456");
    }

}