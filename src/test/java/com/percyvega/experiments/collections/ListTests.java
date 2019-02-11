package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.percyvega.experiments.collections.BibleReference.*;

@Log4j2
public class ListTests {

    @Test
    public void list_elements() {
        addElementAndPrint(new ArrayList<>());
        addElementAndPrint(new LinkedList<>());
        addElementAndPrint(new Vector<>());
    }

    private void addElementAndPrint(List<BibleReference> list) {
        list.add(GENESIS_1_1);
        list.add(EXODUS_1_1);
        list.add(LEVITICUS_1_1);
        list.add(NUMBERS_1_1);
        list.add(DEUTERONOMY_1_1);
        list.add(REVELATION_1_1);
        list.add(REVELATION_22_21);

        log.info("{} Printing {} {}", "***********", list.getClass().getSimpleName(), "***********");
        list.forEach((e) -> log.info(e.getFullName()));
    }

    @Test
    public void list_operations() {
        List<BibleReference> list = new ArrayList<>();
        list.add(GENESIS_1_1);
        list.add(EXODUS_1_1);
        list.add(LEVITICUS_1_1);
        list.add(NUMBERS_1_1);
        list.add(DEUTERONOMY_1_1);
        list.add(REVELATION_1_1);
        list.add(REVELATION_22_21);

        log.info(list.size());
        log.info(list.get(0));
        log.info(list.isEmpty());
        log.info(list.remove(0));
        log.info(list.remove(REVELATION_1_1));
        log.info(list.indexOf(NUMBERS_1_1));
        log.info(list.toArray());
    }

    @Test
    public void arrayList_operations() {
        List<BibleReference> list = new ArrayList<>(Arrays.asList(BibleReferences.getAll()));

        log.info(list.size());
        log.info(list.get(0));
        log.info(list.isEmpty());
        log.info(list.remove(0));
        log.info(list.remove(REVELATION_1_1));
        log.info(list.indexOf(NUMBERS_1_1));
        log.info(list.toArray());
    }


    @Test
    public void arrayList_string_operations() {
        List<String> list = Arrays
                .stream(BibleReferences.getAll())
                .map(BibleReference::getFullName)
                .collect(Collectors.toCollection(ArrayList::new));

        log.info(list.size());
        log.info(list.get(0));
        log.info(list.isEmpty());
        log.info(list.remove(0));
        log.info(list.remove(REVELATION_1_1.getFullName()));
        log.info(list.indexOf(NUMBERS_1_1.getFullName()));
        log.info(list.toArray());
    }

    @Test
    public void linkedList_operations() {
        List<BibleReference> list = new LinkedList<>(Arrays.asList(BibleReferences.getAll()));

        log.info(list.size());
        log.info(list.get(0));
        log.info(list.isEmpty());
        log.info(list.remove(0));
        log.info(list.remove(REVELATION_1_1));
        log.info(list.indexOf(NUMBERS_1_1));
        log.info(list.toArray());

        log.info(list.size());
        log.info(((LinkedList<BibleReference>) list).offer(EXODUS_1_1));
        log.info(list.size());

        log.info(((LinkedList<BibleReference>) list).peek());
        log.info(((LinkedList<BibleReference>) list).poll());
        log.info(((LinkedList<BibleReference>) list).pop());
    }


    @Test
    public void vector_operations() {
        List<BibleReference> list = new Vector<>(Arrays.asList(BibleReferences.getAll()));

        log.info(list.size());
        log.info(list.get(0));
        log.info(list.isEmpty());
        log.info(list.remove(0));
        log.info(list.remove(REVELATION_1_1));
        log.info(list.indexOf(NUMBERS_1_1));
        log.info(list.toArray());
    }
}
