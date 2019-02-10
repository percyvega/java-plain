package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BibleReferences {

    private static final BibleReference[] bibleReferences = BibleCounter.getBibleReferences();

    public static BibleReference[] getAll() {
        return bibleReferences;
    }
}
