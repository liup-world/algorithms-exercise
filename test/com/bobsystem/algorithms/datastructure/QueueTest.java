package com.bobsystem.algorithms.datastructure;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    private final Queue<Integer> queue = new Queue<>();

    @Before
    public void init() {
        Queue<Integer> queue = this.queue;
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }

    @Test
    public void testEnqueueDequeue() {
        Queue<Integer> queue = this.queue;

        System.out.println(queue.enqueue(4));
        System.out.println("queue = " + queue);
        System.out.println("size = " + queue.size());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println("size = " + queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }

    @Test
    public void testClear() {
        Queue<Integer> queue = this.queue;
        System.out.println("queue = " + queue);
        this.queue.clear();
        System.out.println(this.queue.dequeue());
        System.out.println("queue = " + queue);
        this.queue.enqueue(0);
        System.out.println("queue = " + queue);
    }

    @Test
    public void testIsEmptyOrFull() {
        Queue<Integer> queue = this.queue;
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        this.queue.dequeue();
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        this.queue.clear();
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
    }
}
