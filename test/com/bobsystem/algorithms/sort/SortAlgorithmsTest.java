package com.bobsystem.algorithms.sort;

import org.junit.After;
import org.junit.Test;

import java.util.Arrays;

public class SortAlgorithmsTest {

    private final int[] arr = { 7, 8, 9, 6, 5, 4, 2, 3, 1, 0 };

    private final SortAlgorithms algorithm = new SortAlgorithms();

    //region insert sort 直接插入排序、希尔排序
    @Test
    public void testInsertSort() {
        this.algorithm.insertSort(this.arr);
    }

    @Test
    public void testShellSort() {
        this.algorithm.shellSort(this.arr);
    }
    //region insert sort 直接插入排序、希尔排序

    @Test
    public void testSelectSort() {
        algorithm.selectSort(arr);
    }

    //region swap sort 冒泡排序、快速排序
    @Test
    public void testBubbleSort() {
        this.algorithm.bubbleSort(this.arr);
    }

    @Test
    public void testQuickSort() {

        //int[] arr = { 100, -5, -4, -3, -2, -1, 5, 4, 3, 2, 1, 25, 10, 20, 15 };
        //int[] arr = { -10, -9, -8, -7, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] arr = {5, 4, 3, 2, 2, 1};

        this.algorithm.quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }
    //endregion swap sort 冒泡排序、快速排序

    //region merge sort
    @Test
    public void testMergeSort() {
        this.algorithm.mergeSort(this.arr);
    }
    //endregion merge sort

    @Test
    public void testReverseArray() {
        this.algorithm.reverseArray(this.arr);
    }

    @After
    public void afterTest() {
        System.out.println(Arrays.toString(this.arr));
    }
}
