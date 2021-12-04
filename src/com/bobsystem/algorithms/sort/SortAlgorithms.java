package com.bobsystem.algorithms.sort;

/**
 * 排序方法有：
 *   插入排序(直接插入排序、希尔排序、二分法插入排序、二路插入排序、共享栈插入排序)
 *   交换排序(冒泡排序、快速排序)
 *   选择排序(直接选择排序、树型选择排序、堆排序)
 *   合并排序
 */
public class SortAlgorithms {

    //region swap sort 冒泡排序、快速排序
    /**
     * 冒泡排序法逻辑：相邻的两个数比较
     * 5 4 3 2 1
     * 4 5 3 2 1
     * 4 3 5 2 1
     * 4 3 2 5 1
     * 4 3 2 1 5
     *
     * 时间复杂度接近 o(n^2)
     */
    public void bubbleSort(int[] arr) {
        for (int i = 0, c = arr.length; i < c - 1; ++i) {
            // 再减 i 的目的是，相邻两两比较，保证最后 i 位已经正序排列
            for (int j = 0; j < c - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 快速排序法。核心：将数组视为两部分，让左侧所有元素都比右侧小
     * 具体逻辑：
     *   取第一个元素作为 pivot(轴值)，
     *   先从右侧依次与 pivot 比较，小于，将右侧数值赋给左侧；否则取紧挨的下一个数继续。
     *   再从左侧依次与 pivot 比较，大于，将左侧数值赋给右侧；否则取紧挨的下一个数继续。
     *   最后将 pivot 赋予左侧。
     */
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        int left = low;  // left、right 是下标
        int right = high;
        int pivot = arr[low]; // pivot 取 low 位
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
        //System.out.printf("left=%d right=%d pivot=%d%n", left + 1, right + 1, pivot);
        if (left > low) {
            quickSort(arr, low, left);
        }
        if (right < high) {
            quickSort(arr, left + 1, high);
        }
    }
    //endregion swap sort

    //region select sort
    /**
     * 选择排序法逻辑：第 1 位数依次向后面的数比较
     * 5 4 3 2 1
     * 4 5 3 2 1
     * 3 5 4 2 1
     * 2 5 4 3 1
     * 1 5 4 3 2
     *
     * 时间复杂度接近 o(n ^ 2)
     */
    public void selectSort(int[] arr) {
        for (int i = 0, m = arr.length - 1; i < m; ++i) {
            for (int j = i + 1, n = arr.length; j < n; ++j) {
                int tmp = arr[i];
                if (tmp > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    //endregion select sort

    //region insert sort 插入排序、希尔排序
    /**
     * 插入排序法。
     *   逻辑：从第二个元素向后取数，每取一个数，把大于它的数往后挪一位
     *
     * 时间复杂度接近 o(n^2)
     */
    public void insertSort(int[] arr) {
        // { 7, 8, 9, 6, 5, 4, 2, 3, 1, 0 }
        for (int i = 1, c = arr.length; i < c; ++i) {
            int tmp = arr[i];
            int j = i;
            for (; j > 0; --j) {
                if (arr[j - 1] > tmp) {
                    arr[j] = arr[j - 1];
                }
                else break;
            }
            arr[j] = tmp;
        }
    }

    /**
     * 希尔排序。希尔排序质疑了冒泡排序中相邻元素比较和交换的必要性。
     *   逻辑：将数组中一部分元素依次与另一部分比较，具体实现是定义一个间隔，并缩小间隔。
     *
     * 时间复杂度接近 o(n * 2)
     */
    public void shellSort(int[] arr) {
        int times = 0;
        int length = arr.length;
        int gap = length;
        while ((gap /= 2) > 0) {
            for (int i = gap; i < length; ++i) {
                int tmp = arr[i];
                for (; i - gap >= 0 && tmp < arr[i - gap]; i -= gap) {
                    // 这个循环的意义是，将当前元素与之前每个固定间隔位置的元素比较。
                    arr[i] = arr[i - gap];
                    times += 1;
                }
                arr[i] = tmp;
            }
        }
        System.out.println("希尔排序一共交换的次数：" + times);
    }
    //endregion insert sort 插入排序、希尔排序

    //region merge sort
    /**
     * 归并排序。逻辑：
     *   递归将数组对半分割，每次得到一对子数组，直到每个子数组只有一个元素。
     *   再将这对子数组的右侧 与 左侧对应位置比较。
     */
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int middle = (high - low) / 2 + low;
        //
        mergeSort(arr, low, middle);
        mergeSort(arr, middle + 1, high);
        ////
        //System.out.printf("low, high = %d, %d; left, right = %s, %s %n",
        //    low, high,
        //    Arrays.toString(Arrays.copyOfRange(arr, low, middle + 1)),
        //    Arrays.toString(Arrays.copyOfRange(arr, middle + 1, high + 1)));
        int i = low;
        for (int j = middle + 1; i <= middle && j <= high; ++i, ++j) {
            int eleI = arr[i];
            int eleJ = arr[j];
            if (eleI > eleJ) {
                arr[i] = arr[j];
                arr[j] = eleI;
            }
        }
        if (i <= middle) { // 对半分割的过程，左侧也许会比右侧多一个元素
            for (int j = high; j > middle; --j) {
                int eleI = arr[i];
                if (eleI > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = eleI;
                }
            }
        }
    }
    //endregion merge sort

    /**
     * reverse array
     */
    public void reverseArray(int[] arr) {
        for (int i = 0, j = arr.length - 1, c = arr.length / 2; i < c; ++i, --j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
