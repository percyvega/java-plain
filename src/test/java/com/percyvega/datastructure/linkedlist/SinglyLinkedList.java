package com.percyvega.datastructure.linkedlist;

/**
 * Created by percy on 4/16/2017.
 */
public class SinglyLinkedList<E> {

    private int size = 0;
    private SinglyLinkedListNode head;

    public int size() {
        return size;
    }

    public void add(E value) {
        SinglyLinkedListNode<E> newNode = new SinglyLinkedListNode<>(value);
        if (size == 0) {
            head = newNode;
        } else {
            SinglyLinkedListNode<E> iNode;
            for (iNode = head; iNode.next != null; iNode = iNode.next) ;
            iNode.next = newNode;
        }

        size++;
    }

    public SinglyLinkedListNode getHead() {
        return head;
    }
}

class SinglyLinkedListNode<E> {
    E value;
    SinglyLinkedListNode<E> next;

    SinglyLinkedListNode(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
