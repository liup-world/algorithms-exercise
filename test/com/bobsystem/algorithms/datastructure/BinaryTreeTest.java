package com.bobsystem.algorithms.datastructure;

import org.junit.Test;

import java.util.Arrays;

public class BinaryTreeTest {

    @Test
    public void test() {
        int length = 20;
        int[] data = new int[length];
        for (int i = 0; i < length; ++i) {
            data[i] = (int)(Math.random() * 100 + 1);
        }
        System.out.println(Arrays.toString(data));

        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i : data) {
            tree.store(i);
        }

        boolean ret = tree.find(data[19]);
        System.out.println(ret);

        tree.middleList();
        System.out.println();
        System.out.println();

        tree.middleList(true);
        System.out.println();
        System.out.println();

        //tree.preList();
        //System.out.println();
        //System.out.println();
        //
        //tree.afterList();
    }
}
