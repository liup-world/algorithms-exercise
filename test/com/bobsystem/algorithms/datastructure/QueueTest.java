package com.bobsystem.algorithms.datastructure;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    private final Queue<Integer> queue = new Queue<Integer>();

    @Before
    public void init() {

        this.queue.enqueue(0);
        this.queue.enqueue(1);
        this.queue.enqueue(2);
        this.queue.enqueue(3);
    }

    @Test
    public void testEnqueueDequeue() {

        System.out.println(this.queue.enqueue(4));

        System.out.println(this.queue.dequeue());
        System.out.println(this.queue.dequeue());

        System.out.println(this.queue);
    }

    @Test
    public void testClear() {

        System.out.println(this.queue);

        this.queue.clear();
        System.out.println(this.queue);

        this.queue.enqueue(0);
        System.out.println(this.queue);
    }

    @Test
    public void testIsEmptyOrFull() {

        System.out.println(this.queue.isEmpty());
        System.out.println(this.queue.isFull());

        this.queue.dequeue();
        System.out.println(this.queue.isEmpty());
        System.out.println(this.queue.isFull());

        this.queue.clear();
        System.out.println(this.queue.isEmpty());
        System.out.println(this.queue.isFull());
    }
}
