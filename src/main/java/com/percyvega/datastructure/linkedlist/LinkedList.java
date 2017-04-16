package com.percyvega.datastructure.linkedlist;

/**
 * Created by percy on 4/16/2017.
 */
public class LinkedList<T> {

    private int size = 0;
    private Item head;
    private Item tail;

    public int size() {
        return size;
    }

    public void add(T element) {
        Item<T> newItem = new Item<>(element);
        if(size == 0) {
            head = newItem;
            tail = newItem;
        } else {
            tail.next = newItem;
            tail = newItem;
        }

        size++;
    }

    public T get(int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index is " + index + " and size is " + size);

        Item<T> item = head;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item.element;
    }

}

class Item<T> {
    Item<T> prev;
    T element;
    Item<T> next;

    public Item(T element) {
        this.element = element;
    }
}
