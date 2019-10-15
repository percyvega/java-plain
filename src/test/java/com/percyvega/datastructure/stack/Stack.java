package com.percyvega.datastructure.stack;

/**
 * Created by percy on 4/29/2017.
 */
public class Stack<T> {

    private StackNode<T> top;

    public T pop() {
        if (top == null)
            throw new NullPointerException("Stack is isEmpty. Pop is not allowed.");

        T data = top.data;
        top = top.next;

        return data;
    }

    public void push(T data) {
        StackNode<T> newNode = new StackNode<>(data);

        newNode.next = top;
        top = newNode;
    }

    public T peek() {
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class StackNode<T> {
        T data;
        StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

}
