package com.percyvega.experiments.java14.recordclasses;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecordTest {

    public static final String NAME = "Percy";
    public static final int AGE = 44;

    @Test
    void testSimpleRecord() {
        SimpleRecord record = new SimpleRecord(NAME, AGE);
        assertThat(record).isInstanceOf(SimpleRecord.class);

        assertThat(record.name()).isEqualTo(NAME);
        assertThat(record.age()).isEqualTo(AGE);

        assertThat(record.toString()).isEqualTo("SimpleRecord[name=Percy, age=44]");
        assertThat(record).isEqualTo(new SimpleRecord(NAME, AGE));
    }

    @Test
    void testComplexRecord() {
        assertThrows(NullPointerException.class, () -> new ComplexRecord(null, 10));
        assertThrows(IllegalArgumentException.class, () -> new ComplexRecord("John", -10));

        ComplexRecord record = new ComplexRecord("Nicholas", 7);
        assertThat(record.toString()).isEqualTo("ComplexRecord[name=Nicholas, age=7]");

        record = new ComplexRecord("Isabella");
        assertThat(record.toString()).isEqualTo("ComplexRecord[name=Isabella, age=100]");

        record = new ComplexRecord(90);
        assertThat(record.toString()).isEqualTo("ComplexRecord[name=Unknown, age=90]");

        record = new ComplexRecord();
        assertThat(record.toString()).isEqualTo("ComplexRecord[name=Unknown, age=100]");

        record.run();
    }

}
