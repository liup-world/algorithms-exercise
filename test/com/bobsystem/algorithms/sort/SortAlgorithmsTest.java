package com.bobsystem.algorithms.sort;

import org.junit.After;
import org.junit.Test;

import java.util.Arrays;

public class SortAlgorithmsTest {

    //region private fields
    private final int[] arr = { 7, 8, 9, 6, 5, 4, 2, 3, 1, 0 };

    private final SortAlgorithms algorithm = new SortAlgorithms();
    //endregion private fields

    //region swap sort 冒泡排序、快速排序
    @Test
    public void testBubbleSort() {
        this.algorithm.bubbleSort(this.arr);
    }

    @Test
    public void testQuickSort() {
        this.algorithm.quickSort(this.arr);
    }
    //endregion swap sort 冒泡排序、快速排序

    //region select sort
    @Test
    public void testSelectSort() {
        algorithm.selectSort(arr);
    }
    //endregion select sort

    //region insert sort 直接插入排序、希尔排序
    @Test
    public void testInsertSort() {
        this.algorithm.insertSort(this.arr);
    }

    @Test
    public void testShellSort() {
        this.algorithm.shellSort(this.arr);
    }
    //endregion insert sort 直接插入排序、希尔排序

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
