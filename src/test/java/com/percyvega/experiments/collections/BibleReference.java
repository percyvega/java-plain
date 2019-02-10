package com.percyvega.experiments.collections;

import lombok.Data;

@Data
public class BibleReference implements Comparable {

    private static final String SPACE = " ";
    private static final String COLON = ":";

    private String book;
    private int chapter;
    private int verse;
    private String fullName;

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
}
