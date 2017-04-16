package com.percyvega.datastructure.linkedlist;


public class App {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();

        for (int i = 0; i < 32; i++) {
            list1.add(i);
            list2.add("Element " + i);
        }

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i) + ", " + list2.get(i));
        }
    }

}
