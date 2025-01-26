package com.percyvega.datastructure.queue;

import lombok.extern.log4j.Log4j2;

/**
 * Created by percy on 4/30/2017.
 */
@Log4j2
public class AppQueue {

    public static void main(String[] args) {

        Queue<Integer> stack = new Queue<>();

        for (int i = 0; i < 100; i += 7) {
            stack.add(i);
        }

        log.info("Peek: " + stack.peek());

        while (!stack.isEmpty())
            log.info(stack.remove());

    }

}
