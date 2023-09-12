package com.percyvega.experiments.java8.interfaces;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class CollectionsSort {

    List<String> names = Arrays.asList("She", "It", "I", "He", "Abstract", "Internationalization", "Four", "Seven");

    @Test
    void test1() {
        Collections.sort(names);
        assertThat(names.get(0)).isEqualTo("Abstract");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        assertThat(names.get(0)).isEqualTo("I");

        Collections.sort(names, (String o1, String o2) -> {
            return o2.length() - o1.length();
        });
        assertThat(names.get(0)).isEqualTo("Internationalization");

        Collections.sort(names, (String o1, String o2) -> o1.length() - o2.length());
        assertThat(names.get(0)).isEqualTo("I");

        Collections.sort(names, (o1, o2) -> o1.length() - o2.length());
        assertThat(names.get(0)).isEqualTo("I");

        Collections.sort(names, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        assertThat(names.get(0)).isEqualTo("I");

        Collections.sort(names, Comparator.comparingInt(String::length));
        assertThat(names.get(0)).isEqualTo("I");

        names.sort(Comparator.comparingInt(String::length));
        assertThat(names.get(0)).isEqualTo("I");
    }

    @Test
    void testSort() {
        printStrings("Original", names);

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String book1, String book2) {
                return book1.compareTo(book2);
            }
        });
        printStrings("Oldest way", names);

        Collections.sort(names, (a, b) -> {
            return a.compareTo(b);
        });
        printStrings("Lambda, verbose way", names);

        Collections.sort(names, (a, b) -> a.compareTo(b));
        printStrings("Lambda, better way", names);

        names.sort((a, b) -> a.compareTo(b));
        printStrings("Original", names);

        names.sort(Comparator.naturalOrder());
        printStrings("Comparator.naturalOrder()", names);

        Collections.sort(names, Comparator.reverseOrder());
        printStrings("Comparator.reverseOrder()", names);

        Collections.sort(names, String::compareTo);
        printStrings("String::compareTo", names);
    }

    private void printStrings(String name, List<String> strings) {
        System.out.println("\n" + name + ": -------------");
        strings.forEach(System.out::println);
    }

}
