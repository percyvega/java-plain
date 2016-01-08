package com.percyvega.experiments.java8.optional;

import java.util.List;
import java.util.Optional;

public class App {

    public static Optional<String> findLongest(List<String> values) {
        if (values == null || values.size() == 0) {
            return Optional.empty();
        }

        String longest = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            String value = values.get(i);
            if (value.length() > longest.length()) {
                longest = value;
            }
        }

        return Optional.of(longest);
    }

}
