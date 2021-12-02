package com.bobsystem.algorithms.datastructure;

import java.util.Arrays;

/**
 * 栈。这里实现了一个非线程安全的栈。
 */
public class Stack<T> {

    //region property fields
    private final T[] data;
    private int top;
    //endregion property fields

    //region constructor
    public Stack() {
        this(4);
    }

    @SuppressWarnings("unchecked")
    public Stack(int initSize) {
        this.data = (T[])new Object[initSize];
    }
    //endregion constructor

    //region member methods
    public boolean push(T element) {
        T[] data = this.data;
        int top = this.top;
        if (top >= data.length) return false;
        data[top++] = element;
        this.top = top;
        return true;
    }

    public T pop() {
        int top = this.top;
        if (top == 0) return null;
        try {
            this.top = --top;
            return this.data[top];
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int size() {
        return this.top;
    }

    public void clear() {
        this.top = 0;
        Arrays.fill(this.data, null);
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public boolean isFull() {
        return this.top >= this.data.length;
    }

    @Override
    public String toString() {
        if (this.top == 0) return "[]";
        StringBuilder strBuilder = new StringBuilder(50);
        strBuilder.append("[");
        for (int i = 0, c = this.top; i < c; ++i) {
            strBuilder.append(this.data[i]).append(", ");
        }
        strBuilder.append("]");
        return strBuilder.toString();
    }

    public T[] toArray() {
        return this.data;
    }
    //endregion member methods
}
