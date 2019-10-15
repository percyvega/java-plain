package com.percyvega.datastructure.linkedlist;

/**
 * Created by percy on 4/16/2017.
 */
public class DoublyLinkedList<E> {

    private int size = 0;
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;

    public int size() {
        return size;
    }

    public void add(E value) {
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index is " + index + " and size is " + size);

        DoublyLinkedListNode<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public E delete(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index is " + index + " and size is " + size);

        DoublyLinkedListNode<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        if (node == head)
            head = node.next;
        else
            node.prev.next = node.next;

        if (node == tail)
            tail = node.prev;
        else
            node.next.prev = node.prev;

        size--;

        return node.value;
    }

    public DoublyLinkedListNode getHead() {
        return head;
    }

    public DoublyLinkedListNode getTail() {
        return tail;
    }
}

class DoublyLinkedListNode<E> {
    DoublyLinkedListNode<E> prev;
    E value;
    DoublyLinkedListNode<E> next;

    DoublyLinkedListNode(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
