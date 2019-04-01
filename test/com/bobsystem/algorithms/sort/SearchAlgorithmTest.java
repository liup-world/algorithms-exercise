package com.bobsystem.algorithms.sort;

import java.util.Scanner;

public class SearchAlgorithmTest {

    private static final SearchAlgorithms SEARCH_ALGORITHMS = new SearchAlgorithms();

    public static void main(String[] args) {

        // binary search 在顺序的列表中查找
        System.out.print("give me a number(0-13):");
        System.out.flush();

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] sorted = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        SEARCH_ALGORITHMS.binarySearch(sorted, num);
    }
}
