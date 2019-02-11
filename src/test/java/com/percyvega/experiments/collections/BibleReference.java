package com.percyvega.experiments.collections;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
@Data
public class BibleReference implements Comparable {

    public static final BibleReference GENESIS_1_1 = new BibleReference("Genesis", 1, 1);
    public static final BibleReference EXODUS_1_1 = new BibleReference("Exodus", 1, 1);
    public static final BibleReference LEVITICUS_1_1 = new BibleReference("Leviticus", 1, 1);
    public static final BibleReference NUMBERS_1_1 = new BibleReference("Numbers", 1, 1);
    public static final BibleReference DEUTERONOMY_1_1 = new BibleReference("Deuteronomy", 1, 1);
    public static final BibleReference REVELATION_1_1 = new BibleReference("Revelation", 1, 1);
    public static final BibleReference REVELATION_22_21 = new BibleReference("Revelation", 22, 21);

    private static final String SPACE = " ";
    private static final String COLON = ":";

    private String book;
    private int chapter;
    private int verse;
    private String fullName;

    private void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BibleReference(String book, int chapter, int verse) {
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
        this.fullName = new StringBuilder(book)
                .append(SPACE)
                .append(chapter)
                .append(COLON)
                .append(verse)
                .toString();
    }

    // needed for all Tree implementations
    @Override
    public int compareTo(Object other) {
        BibleReference o = (BibleReference) other;

        if(!book.equals(o.book)) {
            return book.compareTo(o.book);
        } else if (chapter != o.chapter) {
            return Integer.compare(chapter, o.chapter);
        }

        return Integer.compare(verse, o.verse);
    }

    // optional, used when this class is a Hashtable value
    @Override
    public boolean equals(Object o) {
//        log.info("Calling equals on {} with parameter {}", this, o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BibleReference that = (BibleReference) o;
        return chapter == that.chapter &&
                verse == that.verse &&
                book.equals(that.book);
    }

    // optional, used when this class is a Hashtable key
    @Override
    public int hashCode() {
        int hash = Objects.hash(book, chapter, verse);
//        log.info("Calling hashCode on {}. Hash {}", this, hash);
        return hash;
    }
}
