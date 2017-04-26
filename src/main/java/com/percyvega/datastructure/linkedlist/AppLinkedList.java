package com.percyvega.datastructure.linkedlist;


public class AppLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();

        populateList(list1, list2);

        System.out.println("About to remove from the head");
        while(list1.size() > 0)
        {
            System.out.println("Size is: " + list1.size());
            printNodes(list1);
            list1.delete(0);
            System.out.println();
        }

        populateList(list1, list2);

        System.out.println("About to remove from the tail");
        while(list1.size() > 0)
        {
            System.out.println("Size is: " + list1.size());
            printNodes(list1);
            list1.delete(list1.size() - 1);
            System.out.println();
        }

        populateList(list1, list2);

        System.out.println("About to remove from the center");
        while(list1.size() > 0)
        {
            System.out.println("Size is: " + list1.size());
            printNodes(list1);
            list1.delete(list1.size() / 2);
            System.out.println();
        }

    }

    private static void populateList(LinkedList<Integer> list1, LinkedList<String> list2)
    {
        for (int i = 0; i < 4; i++) {
            list1.add(i);
            list2.add("Node " + i);
        }
    }

    private static void printNodes(LinkedList<Integer> listList)
    {
        for(Node node = listList.getHead(); node != null; node = node.next)
            System.out.println("node: " + node.value);
    }

}
