package com.bobsystem.algorithms.number;

import java.util.LinkedList;

public class NumberAlgorithms {

    public boolean isPrime(int number) {
        if (number <= 2) {
            return number > 1;
        }
        for (int i = 2, c = (int)Math.sqrt(number); i <= c; ++i) { // Math.sqrt() 求平方根
        //for (int i = 2, c = number / 2; i <= c; ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用过滤的方法求素数
     * 若一个数是素数，它的倍数一定不是素数
     */
    public void showPrimeFilter(int range) {
        // 将范围中的数字添加到数组中
        int[] arr = new int[range + 1];
        for (int i = 2; i <= range; ++i) {
            arr[i] = i;
        }
        for (int i = 2; i <= range; ++i) {
            int number = arr[i];
            if (isPrime(number)) {
                for (int j = number * 2; j <= range; j += number) { // 关键步骤
                    arr[j] = 0; // 若一个数是素数，它的倍数一定不是素数
                }
            }
        }
        for (int i = 2; i <= range; ++i) {
            int number = arr[i];
            if (number != 0) {
                System.out.printf(String.format("%d, ", number));
            }
        }
    }

    public void multiplyTable() {
        //for (int i = 1; i <= 9; ++i) {
        //    for (int j = 1; j <= i; ++j) {
        //        System.out.printf("%d * %d = %d  ", j, i, i * j);
        //    }
        //    System.out.println();
        //}
        // 第二种方式
        for (int i = 1, j = 1; j <= 9; ++i) {
            System.out.printf("%d * %d = %d  ", i, j, i * j);
            if (i == j) {
                i = 0;
                j += 1;
                System.out.println();
            }
        }
    }

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
     * 50人 谁数到3 谁就离开，后面的人重新从1开始数
     * 1 2 3 4 5 6
     */
    public void cycleDelete(int range, int target) {
        LinkedList<Integer> arr = new LinkedList<Integer>();
        for (int i = 1; i <= range; ++i) {
            arr.add(i);
        }
        int index = -1;
        int size;
        while ((size = arr.size()) > 1) {
            if (size < 3) break;
            index = (index + target) % size; // index + target，直接 + target 相等于数到 target

            //System.out.println(index);

            arr.remove(index--);
        }
        System.out.println(arr);
    }

    /**
     * 数字的每一位的 2次幂之和 等于这个数字是阿姆斯特朗数，当幂是3时称为 [水仙花数]
     */
    public void armstrongNumber(int begin, int end) {
        for (int i = begin; i <= end; ++i) {
            for (int j = 2; j <= 3; ++j) { // 二次幂、三次幂
                int number = 0;
                int num = i;
                while (num != 0) {
                    number += Math.pow(num % 10, j);
                    num /= 10;
                }
                if (number == i) {
                    System.out.printf("%s: %d %n", (j == 2 ? "阿姆斯特朗数" : "水 仙 花 数"), i);
                }
            }
        }
    }
}
