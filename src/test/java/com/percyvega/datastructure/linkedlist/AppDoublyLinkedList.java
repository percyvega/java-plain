package com.percyvega.datastructure.linkedlist;


import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppDoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        DoublyLinkedList<String> list2 = new DoublyLinkedList<>();

        populateList(list1, list2);

        log.info("About to remove from the head");
        while (list1.size() > 0) {
            log.info("Size is: " + list1.size());
            printNodes(list1);
            list1.delete(0);
        }

        populateList(list1, list2);

        log.info("About to remove from the tail");
        while (list1.size() > 0) {
            log.info("Size is: " + list1.size());
            printNodes(list1);
            list1.delete(list1.size() - 1);
        }

        populateList(list1, list2);

        log.info("About to remove from the center");
        while (list1.size() > 0) {
            log.info("Size is: " + list1.size());
            printNodes(list1);
            list1.delete(list1.size() / 2);
        }

    }

    private static void populateList(DoublyLinkedList<Integer> list1, DoublyLinkedList<String> list2) {
        for (int i = 0; i < 4; i++) {
            list1.add(i);
            list2.add("Node " + i);
        }
    }

    private static void printNodes(DoublyLinkedList<Integer> listList) {
        for (DoublyLinkedListNode node = listList.getHead(); node != null; node = node.next)
            log.info("node: " + node.value);
    }

}
