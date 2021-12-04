package com.bobsystem.algorithms.sort;

public class SearchAlgorithms {

    /**
     * binary search 在顺序的列表中查找
     */
    public void binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        int times = 0; // 记录查找次数
        boolean findit = false;
        while (left <= right) {
            times += 1;
            int focus = (left + right) / 2;
            int middle = arr[focus];
            if (middle == target) {
                findit = true;
                break;
            }
            if (middle < target) { // at right side
                left = focus + 1;
            }
            else {
                right = focus - 1;
            }
        }

        System.out.printf("查找 %d 次 %s找到", times, (findit ? "" : "未"));
    }
}
