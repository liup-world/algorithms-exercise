package com.bobsystem.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;

public class SortAlgorithmsTest {

    private final SortAlgorithms sortAlgorithms = new SortAlgorithms();

    @Test
    public void testInsertSort() {
        int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        sortAlgorithms.insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testSelectSort() {
        int[] arr = { -2, -5, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 12, 10, 11 };
        sortAlgorithms.selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testBubbleSort() {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        this.sortAlgorithms.bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testQuickSort() {

        //int[] arr = { 100, -5, -4, -3, -2, -1, 5, 4, 3, 2, 1, 25, 10, 20, 15 };
        //int[] arr = { -10, -9, -8, -7, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] arr = {5, 4, 3, 2, 2, 1};

        this.sortAlgorithms.quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testReverseArray() {

        int[] arr = {0, 1, 2, 3, 4, 5, 6};

        this.sortAlgorithms.reverseArray(arr);

        System.out.println(Arrays.toString(arr));
    }
}
