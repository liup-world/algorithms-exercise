package com.bobsystem.algorithms.datastructure;

import java.util.Arrays;

/**
 * 双头队列
 * FIFO
 */
public class Queue<T> {

    private final Object[] data;

    //private int capacity;
    private int head;
    private int tail;
    private int size;

    public Queue() {

        this(4);
    }

    public Queue(int initSize) {

        this.data = new Object[initSize];
        //this.capacity = initSize;
    }

    public boolean enqueue(T element) {

        if (this.size >= this.data.length) return false;

        this.data[this.tail] = element;

        this.tail += 1;
        this.tail %= this.data.length; // 双头队列

        this.size += 1;

        return true;
    }

    public T dequeue() {

        if (this.size == 0) return null;

        T result = (T)this.data[this.head++];

        //for (int i = 1, c = this.data.length; i < c; ++i) {
        //
        //    this.data[i - 1] = this.data[i];
        //}

        this.size -= 1;

        return result;
    }

    public void clear() {

        this.head = 0;
        this.tail = 0;
        this.size = 0;

        Arrays.fill(this.data, null);
    }

    public int size() {

        return this.size;
    }

    public boolean isEmpty() {

        return this.size == 0;
    }

    public boolean isFull() {

        return this.size >= this.data.length;
    }

    @Override
    public String toString() {

        if (this.size == 0) return "";

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = this.head, c = this.head + this.size; i < c; ++i) {

            int index = i % this.data.length;

            Object obj = this.data[index];
            if (obj != null) {

                stringBuilder.append(String.format("%s, ", obj));
            }
        }

        return stringBuilder.toString();
    }
}
