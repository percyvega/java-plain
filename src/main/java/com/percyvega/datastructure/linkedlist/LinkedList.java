package com.percyvega.datastructure.linkedlist;

/**
 * Created by percy on 4/16/2017.
 */
public class LinkedList<E> {

    private int size = 0;
    private Node head;
    private Node tail;

    public int size() {
        return size;
    }

    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if(size == 0) {
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
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index is " + index + " and size is " + size);

        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public E delete(int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index is " + index + " and size is " + size);

        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        if(node == head)
            head = node.next;
        else
            node.prev.next = node.next;

        if(node == tail)
            tail = node.prev;
        else
            node.next.prev = node.prev;

        size--;

        return node.value;
    }

    public Node getHead()
    {
        return head;
    }

    public Node getTail()
    {
        return tail;
    }
}

class Node<E> {
    Node<E> prev;
    E value;
    Node<E> next;

    Node(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
