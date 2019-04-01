package com.bobsystem.algorithms.sort;

public class SortAlgorithms {

    // 排序方法有：
    //  插入排序(直接插入排序、希尔排序、二分法插入排序、二路插入排序、共享栈插入排序)
    //  交换排序(冒泡排序、快速排序)
    //  选择排序(直接选择排序、树型选择排序、堆排序)
    //  合并排序

    /**
     * 插入排序法逻辑：每取一个数把它抽出，把前面大于它的数往后挪一位
     * 5 4 3 2 1
     * 4 5 3 2 1
     * 3 4 5 2 1
     * 2 3 4 5 1
     * 1 2 3 4 5
     */
    public void insertSort(int[] arr) {
        for (int i = 1, c = arr.length; i < c; ++i) {
            int tmp = arr[i];
            int j = i;
            for (; j > 0; --j) {
                if (arr[j - 1] > tmp) {
                    arr[j] = arr[j - 1];
                }
                else {
                    break;
                }
            }
            arr[j] = tmp;
        }
    }

    /**
     * 选择排序法逻辑：第1位数依次向后面的数比较
     * 5 4 3 2 1
     * 4 5 3 2 1
     * 3 5 4 2 1
     * 2 5 4 3 1
     * 1 5 4 3 2
     */
    public void selectSort(int[] arr) {
        for (int i = 0, c = arr.length; i < c; ++i) {
            for (int j = i + 1; j < c; ++j) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序法逻辑：相邻的两个数比较
     * 5 4 3 2 1
     * 4 5 3 2 1
     * 4 3 5 2 1
     * 4 3 2 5 1
     * 4 3 2 1 5
     */
    public void bubbleSort(int[] arr) {
        for (int i = 0, c = arr.length; i < c; ++i) {
            for (int j = 0; j < c - 1 - i; ++j) { // 再减i的目的是，相邻两两比较，保证最后i位已经正序排列
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 快速排序法逻辑：将数组视为两部分，让一部分都比另一部分小
     * 具体逻辑：右侧数值依次和 pivot(轴值)比较，如果小于，将右侧数值赋给左侧
     *          左侧数值依次和 pivot比较，如果大于，将左侧数值赋给右侧 变化过的right位置
     *          然后将 pivot 赋予 变化过的left位置
     */
    private void quickSort(int arr[], int low, int high) {

        int left = low;  // left、right 是下标
        int right = high;

        int pivot = arr[low]; // pivot 取第1位数

        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;

        System.out.printf("left=%d right=%d pivot=%d%n", left + 1, right + 1, pivot);

        if (left > low) {
            quickSort(arr, low, left - 1);
        }
        if (right < high) {
            quickSort(arr, left + 1, high);
        }
    }

    public void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    // reverse array
    public void reverseArray(int[] arr) {
        for (int i = 0, j = arr.length - 1, c = arr.length / 2; i < c; ++i, --j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
