package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class BibleReferencesTest {

    @Test
    void testGetBibleReferences() {
        assertThat(BibleReferences.getAll().length).isEqualTo(31103);
        assertThat(BibleReferences.getAll().length).isEqualTo(BibleCounter.getTotalVerseCount());

        assertThat(BibleReferences.getAll()[0].getFullName()).isEqualTo("Genesis 1:1");
        assertThat(BibleReferences.getAll()[BibleReferences.getAll().length - 1].getFullName()).isEqualTo("Revelation 22:21");
    }

    @Test
    void iterable_iterator() {
        Iterator<BibleReference> iterator = new BibleReferences().iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next().getFullName()).isEqualTo("Genesis 1:1");
        assertThat(iterator.next().getFullName()).isEqualTo("Genesis 1:2");
        assertThat(iterator.next().getFullName()).isEqualTo("Genesis 1:3");
        assertThat(iterator.next().getFullName()).isEqualTo("Genesis 1:4");
    }

    @Test
    void iterable_forEach() {
        Arrays.stream(Arrays.copyOf(BibleReferences.getAll(), 10)).forEach(bibleReference -> log.info(bibleReference.getFullName()));
    }

}