package com.bobsystem.algorithms.datastructure;

import org.junit.Test;

import java.util.Arrays;

public class BinaryNodeTest {

    @Test
    public void test() {

        int[] data = new int[20];
        for (int i = 0; i < data.length; ++i) {

            data[i] = (int)(Math.random() * 100 + 1);
        }
        System.out.println(Arrays.toString(data));

        BinaryNode<Integer> root = new BinaryNode<Integer>();
        for (int i : data) {

            root.store(i);
        }

        boolean ret = root.find(data[19]);
        System.out.println(ret);

        //root.preList();
        //System.out.println();

        root.middleList();
        System.out.println();

        //root.afterList();
    }
}
