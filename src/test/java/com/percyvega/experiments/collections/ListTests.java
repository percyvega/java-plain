package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.percyvega.experiments.collections.BibleReference.*;

@Log4j2
public class ListTests {

    static List<BibleReference> bibleReferenceList = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        bibleReferenceList.add(GENESIS_1_1);
        bibleReferenceList.add(EXODUS_1_1);
        bibleReferenceList.add(LEVITICUS_1_1);
        bibleReferenceList.add(NUMBERS_1_1);
        bibleReferenceList.add(DEUTERONOMY_1_1);
        bibleReferenceList.add(REVELATION_1_1);
        bibleReferenceList.add(REVELATION_22_21);
    }

    @Test
    public void list_elements() {
        addElementAndPrint(new ArrayList<>());
        addElementAndPrint(new LinkedList<>());
        addElementAndPrint(new Vector<>());
    }

    private void addElementAndPrint(List<BibleReference> list) {
        list.addAll(bibleReferenceList);

        log.info("{} Printing {} {}", "***********", list.getClass().getSimpleName(), "***********");
        list.forEach((e) -> log.info(e.getFullName()));
    }

    @Test
    public void list_operations() {
        List<BibleReference> list = new ArrayList<>(bibleReferenceList);

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
        ArrayList<BibleReference> list = new ArrayList<>(bibleReferenceList);

        log.info(list.size());
        log.info(list.get(0));
        log.info(list.isEmpty());
        log.info(list.remove(0));
        log.info(list.remove(REVELATION_1_1));
        log.info(list.indexOf(NUMBERS_1_1));
        log.info(list.toArray());
    }


    @Test
    public void linkedList_operations() {
        LinkedList<BibleReference> list = new LinkedList<>(bibleReferenceList);

        log.info(list.getFirst());
        log.info(list.getLast());
        log.info(list.removeFirst());
        log.info(list.removeLast());

        log.info(list.size());
        log.info(list.offer(EXODUS_1_1));
        log.info(list.size());

        log.info(list.peek());
        log.info(list.poll());
        log.info(list.pop());
    }


    @Test
    public void vector_operations() {
        Vector<BibleReference> list = new Vector<>(Arrays.asList(BibleReferences.getAll()));

        log.info(list.size());
        log.info(list.get(0));
        log.info(list.isEmpty());
        log.info(list.remove(0));
        log.info(list.remove(REVELATION_1_1));
        log.info(list.indexOf(NUMBERS_1_1));
        log.info(list.toArray());
    }
}
