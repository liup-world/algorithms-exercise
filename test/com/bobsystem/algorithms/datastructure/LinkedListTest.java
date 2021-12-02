package com.bobsystem.algorithms.datastructure;

import org.junit.Test;

import java.util.Iterator;

public class LinkedListTest {

    @Test
    public void test() {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.insert(40, 3);

        System.out.println(list);
        //list.removeAt(4);
        //list.remove(50);

        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println(list.get(4));
        System.out.println(list.size());

        list.clear();
        System.out.println(list.size());
    }
}
