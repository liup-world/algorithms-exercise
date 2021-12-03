package com.bobsystem.algorithms.number;

import java.util.LinkedList;

public class NumberAlgorithms {

    //region prime number
    /**
     * 素数/质数，在大于 1 的自然数中，除了 1 和 它本身 以外不再有其他因数的自然数称为质数。
     * 实现逻辑：
     *   一个数 n 显然不能被 大于 n / 2 小于 n 的数整除，
     *     所以不必遍历 n / 2 到 n 的数字。遍历范围是 [2 ~ n / 2]
     *   进一步优化：一个非质数 n，在它的平方根以内必然存在它的因数，如 16，
     *     所以遍历范围进一步缩小：[2 ~ sqrt(n)]
     */
    public void showPrime(int range) {
        for (int i = 2; i <= range; ++i) {
            boolean ret = isPrime(i);
            if (ret) System.out.print(i + ", ");
        }
    }

    private boolean isPrime(int number) {
        if (number <= 2) return number > 1;
        //for (int i = 2, c = number / 2; i <= c; ++i) {
        for (int i = 2, c = (int)Math.sqrt(number); i <= c; ++i) { // Math.sqrt() 求平方根
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用过滤的方法求素数。
     *   原理：若一个数是素数，它的倍数一定不是素数，因此擦除这些数
     */
    public void showPrimeFilter(int range) {
        // 将范围中的数字添加到数组中
        int[] arr = new int[range + 1];
        for (int i = 2; i <= range; ++i) {
            arr[i] = i;
        }
        for (int i = 2; i <= range; ++i) {
            int number = arr[i];
            if (number == 0) continue;
            if (isPrime(number)) {
                for (int j = number * 2; j <= range; j += number) { // 关键步骤
                    arr[j] = 0; // 若一个数是素数，它的倍数一定不是素数
                }
            }
        }
        for (int i = 2; i <= range; ++i) {
            int number = arr[i];
            if (number != 0) {
                System.out.print(number + ", ");
            }
        }
    }
    //endregion prime number

    /**
     * 乘法口诀表
     */
    public void multiplyTable() {
        //for (int i = 1; i <= 9; ++i) {
        //    for (int j = 1; j <= i; ++j) {
        //        System.out.printf("%d * %d = %d  ", j, i, i * j);
        //    }
        //    System.out.println();
        //}
        /*
         * 第二种方式，逻辑：
         *   既然乘法口决表是一行行的打印，那就在打印完一行后恢复状态打印下一行。
         *   所有的双层循环都可简化为一层循环。
         */
        for (int i = 1, j = 1; j <= 9; ++i) {
            System.out.printf("%d * %d = %d  ", i, j, i * j);
            if (i == j) {
                i = 0;
                j += 1;
                System.out.println();
            }
        }
    }

    /**
     * 判断一个数是否是对称的数字。如 20211202、20200202。
     */
    public boolean isCircleNumber(int number) {
        // 121 => 121
        int reverse = 0;
        int num = number;
        while (num != 0) {
            reverse *= 10;
            reverse += num % 10;
            num /= 10;
        }
        return number == reverse;
    }

    /**
     * 50人 谁数到 3 谁就离开，后面的人重新从 1 开始数
     * 1 2  [3] 4   5 6
     * 1 2      4   5 [6]
     * 1 2      [4] 5
     * 1 [2]        5
     * 1            5
     */
    public void cycleDelete(int range, int target) {
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 1; i <= range; ++i) {
            arr.add(i);
        }
        int index = -1;
        int size;
        while ((size = arr.size()) >= target) {
            index = (index + target) % size; // index + target，直接 + target 相等于数到 target
            //System.out.println(index);
            arr.remove(index--);
        }
        System.out.println(arr);
    }

    /**
     * 数字每一位的 2次幂之和 等于这个数字是 阿姆斯特朗数，当幂是 3 时称为 [水仙花数]
     */
    public void armstrongNumber(int begin, int end) {
        for (int i = begin; i <= end; ++i) {
            for (int j = 2; j <= 3; ++j) { // 二次幂、三次幂
                int newNum = 0;
                int current = i;
                while (current != 0) {
                    newNum += Math.pow(current % 10, j);
                    current /= 10;
                }
                if (newNum == i) {
                    System.out.printf("%s: %d %n", (j == 2 ? "阿姆斯特朗数" : "水 仙 花 数"), i);
                }
            }
        }
    }
}
