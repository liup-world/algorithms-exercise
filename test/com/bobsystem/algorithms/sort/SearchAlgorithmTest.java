package com.bobsystem.algorithms.sort;

import java.util.Scanner;

public class SearchAlgorithmTest {

    private static final SearchAlgorithms SEARCH_ALGORITHMS = new SearchAlgorithms();

    public static void main(String[] args) {
        // binary search 在顺序的列表中查找
        System.out.print("give me a number (1 - 8):");
        System.out.flush();

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] sorted = { 1, 2, 3, 4, 5, 6, 7, 8 };
        SEARCH_ALGORITHMS.binarySearch(sorted, num);
    }
}
