package com.percyvega.datastructure.stack;

import lombok.extern.log4j.Log4j2;

/**
 * Created by percy on 4/29/2017.
 */
@Log4j2
public class AppStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 100; i += 7) {
            stack.push(i);
        }

        log.info("Peek: " + stack.peek());

        while (!stack.isEmpty())
            log.info(stack.pop());

    }

}
