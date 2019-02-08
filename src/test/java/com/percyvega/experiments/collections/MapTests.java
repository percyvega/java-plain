package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.*;

@Log4j2
public class MapTests {

    @Test
    public void map_operations() {
        Map<String, List<String>> dictionary = new HashMap<>();

        List<String> javaLexicon = new ArrayList<>();
        javaLexicon.add("coffee");
        javaLexicon.add("programming language");

        List<String> liveLexicon = new ArrayList<>();
        liveLexicon.add("in person");
        liveLexicon.add("alive");

        dictionary.put("java", javaLexicon);
        dictionary.put("live", liveLexicon);

        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            log.debug("Key: " + key + ", Value: " + value);
        }
    }

}
