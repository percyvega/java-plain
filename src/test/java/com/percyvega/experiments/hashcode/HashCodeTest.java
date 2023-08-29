package com.percyvega.experiments.hashcode;

import com.percyvega.experiments.hashcode.model.Pet;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class HashCodeTest {

    private static final String s1 = String.valueOf(10);
    private static final String s2 = String.valueOf(100);

    @Test
    void testHashCode() {
        // The hashcode() method is a non-final instance method, and should be overridden in any class where the equals(Object) is overridden.

        // The hashCode() method of the Object class is a native method which is may or may not implement it by converting the
        //      internal address of the object into an integer as the hash code value (depends on the internal implementation of the JVM).

        // In the immutable String class, the hashCode() is overridden and implemented using the content of the String object to
        //      make it consistent for use in hash data structures.
        assertThat(s1.hashCode()).isEqualTo(1567);
        assertThat(s1.hashCode()).isEqualTo(1567);
        assertThat(s2.hashCode()).isEqualTo(48625);

        // StringBuffer does not override the hashCode() method inherited from Object class, so the Object class's
        //      implementation of hashCode() is used. This makes it inconsistent.
        // StringBuffer is a mutable object. This makes it unsuitable for use in any "hash" based data structures like a HashMap as it will be inconsistent.
        //      Generally, it is not useful to override hashCode() for mutable objects, since modifying such an object used as a key in a HashMap could cause the stored value to be "lost."

//        assertThat(new StringBuffer(s1).hashCode()).isEqualTo(520022247);
//        assertThat(new StringBuffer(s1).hashCode()).isEqualTo(518522822);
//        assertThat(new StringBuffer(s2).hashCode()).isEqualTo(124407148);

//        assertThat(new StringBuilder(s1).hashCode()).isEqualTo(85445963);
//        assertThat(new StringBuilder(s1).hashCode()).isEqualTo(1825027294);
//        assertThat(new StringBuilder(s2).hashCode()).isEqualTo(852445367);

        assertThat(Integer.valueOf(s1).hashCode()).isEqualTo(10);
        assertThat(Integer.valueOf(s1).hashCode()).isEqualTo(10);
        assertThat(Integer.valueOf(s2).hashCode()).isEqualTo(100);

        assertThat(Long.valueOf(s1).hashCode()).isEqualTo(10);
        assertThat(Long.valueOf(s1).hashCode()).isEqualTo(10);
        assertThat(Long.valueOf(s2).hashCode()).isEqualTo(100);

        assertThat(Float.valueOf(s1).hashCode()).isEqualTo(1092616192);
        assertThat(Float.valueOf(s1).hashCode()).isEqualTo(1092616192);
        assertThat(Float.valueOf(s2).hashCode()).isEqualTo(1120403456);

        assertThat(Double.valueOf(s1).hashCode()).isEqualTo(1076101120);
        assertThat(Double.valueOf(s1).hashCode()).isEqualTo(1076101120);
        assertThat(Double.valueOf(s2).hashCode()).isEqualTo(1079574528);

        assertThat(new Pet(s1, LocalDate.of(2000, Month.AUGUST, 23)).hashCode()).isEqualTo(4192469);
        assertThat(new Pet(s1, LocalDate.of(2000, Month.AUGUST, 23)).hashCode()).isEqualTo(4192469);
        assertThat(new Pet(s2, LocalDate.of(2000, Month.JANUARY, 1)).hashCode()).isEqualTo(6968421);
    }
}

