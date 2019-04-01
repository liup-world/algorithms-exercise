package com.bobsystem.algorithms.datastructure;

import org.junit.Test;

import java.util.Iterator;

public class LinckedListTest {

    @Test
    public void test() {

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.insert(40, 3);
        //list.removeAt(4);
        //list.remove(50);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
        System.out.println(list.get(4));
        System.out.println(list.size());

        list.clear();
        System.out.println(list.size());
    }
}
