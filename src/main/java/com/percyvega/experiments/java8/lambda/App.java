package com.percyvega.experiments.java8.lambda;

import java.util.List;
import java.util.Optional;

public class App {

    /*
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
    */

    public static Optional<String> findLongest(List<String> values) {
        if (values == null || values.size() == 0) {
            return Optional.empty();
        }

        return values
                .stream()
                .reduce((s1, s2) -> s2.length() > s1.length() ? s2 : s1);
    }

}
