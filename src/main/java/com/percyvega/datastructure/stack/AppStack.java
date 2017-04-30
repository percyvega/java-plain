package com.percyvega.datastructure.stack;

/**
 * Created by percy on 4/29/2017.
 */
public class AppStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 100; i += 7) {
            stack.push(i);
        }

        System.out.println("Peek: " + stack.peek());

        while (!stack.isEmpty())
            System.out.println(stack.pop());

    }

}
