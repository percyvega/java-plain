package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
public class BibleReferences implements Iterable<BibleReference> {

    private static final BibleReference[] bibleReferences = BibleCounter.getBibleReferences();

    public static BibleReference[] getAll() {
        return bibleReferences;
    }

    @Override
    public Iterator<BibleReference> iterator() {
//        return Arrays.asList(getAll()).iterator();

        BibleReference[] bibleReferences = Arrays.copyOf(getAll(), 10);
        AtomicInteger nextIndex = new AtomicInteger(0);

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return nextIndex.get() < bibleReferences.length;
            }

            @Override
            public BibleReference next() {
                return bibleReferences[nextIndex.getAndIncrement()];
            }
        };
    }
}
