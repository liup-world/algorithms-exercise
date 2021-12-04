package com.bobsystem.algorithms.sort;

import org.junit.Test;

public class SearchAlgorithmTest {

    private final SearchAlgorithms algorithm = new SearchAlgorithms();

    /**
     * binary search 在顺序的列表中查找
     */
    @Test
    public void testBinarySearch() {
        int num = 3;

        int[] sorted = { 1, 2, 3, 4, 5, 6, 7, 8 };
        this.algorithm.binarySearch(sorted, num);
    }
}
