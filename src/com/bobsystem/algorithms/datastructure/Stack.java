package com.bobsystem.algorithms.datastructure;

import java.util.Arrays;

public class Stack<T> {

    private final Object[] data;
    private int top;

    public Stack() {

        this(4);
    }

    public Stack(int initSize) {

        this.data = new Object[initSize];
    }

    public boolean push(T element) {

        if (this.top >= this.data.length) return false;

        this.data[this.top++] = element;

        return true;
    }

    public T pop() {

        if (this.top == 0) return null;

        try {
            return (T) this.data[--this.top];
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

        if (this.top == 0) return "";

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0, c = this.top; i < c; ++i) {

            Object obj = this.data[i];
            if (obj != null) {
                stringBuilder.append(String.format("%s, ", obj));
            }
        }
        return stringBuilder.toString();
    }
}
