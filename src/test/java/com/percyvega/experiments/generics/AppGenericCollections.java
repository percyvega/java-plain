package com.percyvega.experiments.generics;


import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.*;

/*
    You can use anything, but these are the conventions:
        E - Element
        K - Key
        N - Number
        T - Type
        V - Value
        ? - unknown - where the type of objects are irrelevant (e.g. counting list elements)
 */

@Log4j2
public class AppGenericCollections {


    @Test
    public void testCollections() {
        Set setOfRawType = new HashSet<String>();
        setOfRawType = new HashSet<Integer>();

        Set<Object> setOfAnyType = new HashSet<Object>();
        setOfAnyType.add("abc"); //legal
        setOfAnyType.add(3.0f);

        Set<?> setOfUnknownType = new LinkedHashSet<String>();
        setOfUnknownType = new LinkedHashSet<Integer>();

        Set<String> setOfString = new HashSet<String>(); //valid in Generics
        setOfString = new LinkedHashSet<String>(); // Ok

//        Set<Object> setOfObject = new HashSet<String>();

        Set<? extends Number> setOfAllSubTypeOfNumber = new HashSet<Integer>(); //legal - Integer extends Number
        setOfAllSubTypeOfNumber = new HashSet<Float>(); //legal - because Float extends Number

        Set<? super TreeMap> setOfAllSuperTypeOfTreeMap = new LinkedHashSet<TreeMap>(); //legal because TreeMap is superType of itself
        setOfAllSuperTypeOfTreeMap = new HashSet<SortedMap>(); //legal because SorteMap is super class of TreeMap
        setOfAllSuperTypeOfTreeMap = new LinkedHashSet<Map>(); //legal since Map is super type of TreeMap

        List<?> list = Arrays.asList(4, 2, 10, 18, 10, 16, 36, 34);
        printCollection(list);
        printCollectionOfUnknowns(list);

        List<Object> list2 = Arrays.asList(4, 2, 10, 18, 10, 16, 36, 34);
        printCollectionOfObjects(list2);
    }

    public void printCollection(Collection c) {
        Iterator i = c.iterator();
        for (int k = 0; k < c.size(); k++) {
            log.debug(i.next().toString());
        }
    }

    public void printCollectionOfObjects(Collection<Object> c) {
        for (Object e : c) {
            log.debug(e.toString());
        }
    }

    public void printCollectionOfUnknowns(Collection<?> c) {
        for (Object e : c) {
            log.debug(e.toString());
        }
    }

}