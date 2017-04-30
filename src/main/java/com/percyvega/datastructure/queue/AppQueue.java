package com.percyvega.datastructure.queue;

/**
 * Created by percy on 4/30/2017.
 */
public class AppQueue {

    public static void main(String[] args) {

        Queue<Integer> stack = new Queue<>();

        for (int i = 0; i < 100; i += 7) {
            stack.add(i);
        }

        System.out.println("Peek: " + stack.peek());

        while (!stack.isEmpty())
            System.out.println(stack.remove());

    }

}
