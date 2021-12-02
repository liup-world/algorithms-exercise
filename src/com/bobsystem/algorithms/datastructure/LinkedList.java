package com.bobsystem.algorithms.datastructure;

import java.util.Iterator;

/**
 * 单向链表。这里实现了一个非线程安全的 单向链表。
 */
public class LinkedList<T>
    implements Iterable<T> {

    private LinkedListNode head;

    //region member methods
    public T get(int index) {
        if (index < 0 || this.head == null) return null;
        int i = 0;
        LinkedListNode previous = this.head;
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
        LinkedListNode node = new LinkedListNode(value);
        if (this.head == null) {
            this.head = node;
            return;
        }
        LinkedListNode previous = this.head;
        while (previous.next != null) {
            previous = previous.next;
        }
        previous.next = node;
    }

    public void insert(T value, int index) {
        LinkedListNode node = new LinkedListNode(value);
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
        LinkedListNode current = this.head;
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
        LinkedListNode current = this.head;
        if (current == null) return;
        T headValue = current.value;
        if (headValue == value || headValue.equals(value)) {
            this.head = current.next;
            return;
        }
        boolean typeString = (value instanceof String);
        while (current.next != null && (
            (typeString && !current.next.value.equals(value)) ||
            (!typeString && current.next.value != value))
        ) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void removeAt(int index) {
        LinkedListNode current = this.head;
        if (current == null) return;
        if (index == 0) {
            this.head = current.next;
            return;
        }
        int i = 0;
        while (current.next != null) {
            if (i == index - 1) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
            i += 1;
        }
    }

    public void clear() {
        this.head = null;
    }

    public long size() {
        LinkedListNode node = this.head;
        if (node == null) return 0;
        long result = 1;
        while (node.next != null) {
            result += 1;
            node = node.next;
        }
        return result;
    }

    /**
     * 实现可迭代接口后，可以使用 foreach 来迭代每个元素
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(this.head);
    }

    @Override
    public String toString() {
        final StringBuilder strBuild = new StringBuilder("[");
        strBuild.append(head).append(',');
        while (head.next != null) {
            strBuild.append(head.next).append(',');
            head = head.next;
        }
        strBuild.append(']');
        return strBuild.toString();
    }

    //endregion member methods

    //region inner class
    private class LinkedListNode {

        private final T value;
        private LinkedListNode next;

        private LinkedListNode(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("Node{value='%s'}", value);
        }
    }

    private class LinkedListIterator
        implements Iterator<T> {

        private LinkedListNode current;

        private LinkedListIterator(LinkedListNode head) {
            this.current = head;
        }

        @Override
        public T next() {
            LinkedListNode current = this.current;
            if (current == null) {
                return null;
            }
            T result = current.value;
            this.current = current.next;
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
    //endregion inner class
}
