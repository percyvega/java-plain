package com.percyvega.experiments.collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MyCollections {

    private static final Logger logger = LoggerFactory.getLogger(MyCollections.class);

    public static void useSets() {
        Set<Integer> ages = new HashSet<>();
        ages.add(34); // {34}
        ages.addAll(Arrays.asList(34, 2, 7, 52, 23)); // {34, 2, 7, 52, 23}
        ages.removeAll(Arrays.asList(34, 52)); // {2, 7, 23}
        ages.retainAll(Arrays.asList(1, 2, 23)); // {2, 23}

        Set<String> lastNames = new HashSet<>(Arrays.asList("Vega", "Castillo", "Bobadilla", "Ponze"));

        logger.debug("---------- Sets { ----------");
        for (Integer age : ages)
            logger.debug(age.toString());
        for (String lastName : lastNames) {
            logger.debug(lastName);
        }
        logger.debug("---------- } Sets ----------");
    }

    public static void useMaps() {
        Map<String, List<String>> dictionary = new HashMap<>();

        List<String> javaLexicon = new ArrayList<>();
        javaLexicon.add("coffee");
        javaLexicon.add("programming language");

        List<String> liveLexicon = new ArrayList<>();
        liveLexicon.add("in person");
        liveLexicon.add("alive");

        dictionary.put("java", javaLexicon);
        dictionary.put("live", liveLexicon);

        logger.debug("++++++++++ Maps { ++++++++++");
        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            logger.debug("Key: " + key + ", Value: " + value);
        }
        logger.debug("++++++++++ } Maps ++++++++++");
    }

    public static void useLists() {
        List<String> places1 = Arrays.asList("Buenos Aires", "Córdoba"); // unmutable list
        ArrayList<String> places2 = new ArrayList<>(Arrays.asList("Bariloche", "La Plata"));

        logger.debug("********** Lists { **********");
        // places1.add("Mendoza"); throws exception for trying to add an item to an unmutable list
        for (String aPlaces1 : places1)
            logger.debug(aPlaces1);

        places2.add("Mar de Plata");
        for (String place : places2)
            logger.debug(place);
        logger.debug("********** } Lists **********");
    }

}
