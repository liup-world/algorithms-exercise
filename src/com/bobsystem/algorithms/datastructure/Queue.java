package com.bobsystem.algorithms.datastructure;

import java.util.Arrays;

/**
 * 循环队列。这里实现了一个非线程安全的循环队列。
 * FIFO
 */
public class Queue<T> {

    //region property fields
    private final T[] data;

    private final int capacity;
    private int head;
    private int tail;
    private int size;
    //endregion property fields

    //region constructor
    public Queue() {
        this(4);
    }

    @SuppressWarnings("unchecked")
    public Queue(int initSize) {
        this.data = (T[])new Object[initSize];
        this.capacity = initSize;
    }
    //endregion constructor

    //region member methods

    /**
     * 入队，添加到尾巴上
     */
    public boolean enqueue(T element) {
        T[] data = this.data;
        int tail = this.tail;
        data[tail] = element;
        this.tail = ++tail % data.length; // 循环队列
        int size = this.size;
        int capacity = this.capacity;
        if (++size > capacity) {
            this.size = capacity;
            this.head = this.tail; // tail 指向了结束位置 + 1 的地方，即 head
        }
        else {
            this.size = size;
        }
        return true;
    }

    /**
     * 出队，从头上取出一元素。
     * @return 返回出队的元素。
     */
    public T dequeue() {
        if (this.size == 0) return null;
        int head = this.head;
        T result = this.data[head++];
        this.head = head % this.capacity;
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
        return this.size >= this.capacity;
    }

    @Override
    public String toString() {
        int size = this.size;
        if (size == 0) return "[]";
        int head = this.head;
        T[] data = this.data;
        StringBuilder strBuilder = new StringBuilder(50);
        strBuilder.append('[');
        for (int i = head, c = head + size; i < c; ++i) {
            strBuilder.append(data[i % data.length]).append(", ");
        }
        strBuilder.append(']');
        return strBuilder.toString();
    }
    //endregion member methods
}
