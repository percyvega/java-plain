package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BibleReferencesTest {

    @Test
    public void testGetBibleReferences() {
        assertThat(BibleReferences.getAll().length).isEqualTo(31103);
        assertThat(BibleReferences.getAll().length).isEqualTo(BibleCounter.getTotalVerseCount());

        assertThat(BibleReferences.getAll()[0].getFullName()).isEqualTo("Genesis 1:1");
        assertThat(BibleReferences.getAll()[BibleReferences.getAll().length - 1].getFullName()).isEqualTo("Revelation 22:21");
    }

}