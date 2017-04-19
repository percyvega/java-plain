package com.percyvega.datastructure.linkedlist;


public class AppLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();

        for (int i = 0; i < 32; i++) {
            list1.add(i);
            list2.add("Element " + i);
        }

        for (int i = 0; i < list1.size(); i++) {
            System.out.println("List 1 element: " + list1.get(i) + ".\t\tList 2 element: " + list2.get(i));
        }
    }

}
