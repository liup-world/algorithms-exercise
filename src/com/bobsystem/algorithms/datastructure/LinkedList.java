package com.bobsystem.algorithms.datastructure;

import java.util.Iterator;

public class LinkedList<T>
    implements Iterable<T> {

    private Node head;

    public T get(int index) {

        if (index < 0 || this.head == null) return null;

        int i = 0;
        Node previous = this.head;
        while (previous.next != null) {

            if (i == index) {
                return previous.value;
            }
            previous = previous.next;
            i += 1;
        }
        if (index > i) return null;

        return previous.value;
    }

    public void add(T value) {

        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node previous = this.head;
        while (previous.next != null) {
            previous = previous.next;
        }
        previous.next = node;
    }

    public void insert(T value, int index) {

        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
            return;
        }
        if (index == 0) {
            node.next = this.head;
            this.head = node;
            return;
        }
        int i = 0;
        Node current = this.head;
        while (current.next != null) {
            if (i == index - 1) {
                node.next = current.next;
                current.next = node;
                return;
            }
            current = current.next;
            i += 1;
        }
        current.next = node;
    }

    public void remove(T value) {

        if (this.head == null) return;

        if (this.head.value == value || this.head.value.equals(value)) {
            this.head = this.head.next;
            return;
        }
        Node previous = this.head;
        while (previous.next != null && !previous.next.value.equals(value)) {

            previous = previous.next;
        }
        if (previous.next != null) {
            previous.next = previous.next.next;
        }
    }

    public void removeAt(int index) {

        if (this.head == null) return;

        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        int i = 0;
        Node previous = this.head;
        while (previous.next != null) {

            if (i == index - 1) {
                previous.next = previous.next.next;
                break;
            }
            previous = previous.next;
            i += 1;
        }
    }

    public void clear() {

        this.head = null;
    }

    public long size() {

        if (this.head == null) return 0;

        long result = 1;

        Node node = this.head;
        while (node.next != null) {

            result += 1;

            node = node.next;
        }

        return result;
    }

    @Override
    public Iterator<T> iterator() {

        return new LinkedListIterator(this.head);
    }

    private class Node {

        private T value;
        private Node next;

        private Node(T value) {

            this.value = value;
        }

        @Override
        public String toString() {

            return String.format("Node{value='%s'}", value);
        }
    }

    private class LinkedListIterator
        implements Iterator<T> {

        private Node current;

        private LinkedListIterator(Node head) {
            this.current = head;
        }

        @Override
        public T next() {

            if (this.current == null) {
                return null;
            }

            T result = this.current.value;

            this.current = this.current.next;

            return result;
        }

        @Override
        public boolean hasNext() {

            return this.current != null;
        }

        @Override
        public void remove() {
            this.current = this.current.next;
        }
    }
}
