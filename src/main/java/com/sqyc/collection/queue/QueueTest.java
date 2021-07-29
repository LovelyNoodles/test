package com.sqyc.collection.queue;

import org.junit.Test;

import java.util.ArrayDeque;

public class QueueTest {
    @Test
    public void test1() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
//        ArrayDeque<Integer> queue = new ArrayDeque<>(Integer.MAX_VALUE);
//        ArrayDeque<Integer> queue = new ArrayDeque<>(Integer.valueOf("40000000", 16));
//        ArrayDeque<Integer> queue = new ArrayDeque<>(Integer.valueOf("20000000", 16));
        queue.add(0);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        queue.addFirst(5);
        System.out.println(queue);
    }

}
