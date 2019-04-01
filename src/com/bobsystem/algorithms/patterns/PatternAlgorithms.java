package com.bobsystem.algorithms.patterns;

public class PatternAlgorithms {

    // 等腰三角形
    public void printTriangle(int tier) {

        for (int i = 0; i < tier; ++i) {

            for (int j = 0, c = tier - i - 1; j < c; ++j) {

                System.out.print(" ");
            }
            for (int j = 0; j <= i; ++j) {

                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 打印菱形
    public void printRhombus(int tier) {

        int half = tier / 2;
        if (tier % 2 == 1) {

            half += 1;
        }
        printTriangle(half);

        half -= 1;
        for (int i = 0; i < half; ++i) {

            for (int j = 0; j <= i; ++j) {

                System.out.print(" ");
            }
            for (int j = half - i; j > 0; --j) {

                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * 打印 杨辉三角形，又称贾宪三角形，帕斯卡三角形
     * 每一层的第 n 个数 都是上一层 第 n 个数 和 第 n-1 个数之和
     */
    public void printPascalsTriangle(int tier) {

        int[] arr = new int[tier]; // arr 上一层数的数组
        arr[0] = 1;

        for (int i = 0; i < tier; ++i) {

            for (int j = 0, c = tier - i; j < c; ++j) {

                System.out.print("  ");
            }
            int[] arr2 = new int[tier]; // arr2 当前打印层的数组
            for (int j = 0; j <= i; ++j) {

                int num = arr[j];
                if (j > 0) {
                    num += arr[j - 1];
                }
                System.out.printf("% 3d ", num);

                arr2[j] = num;
            }
            System.out.println();
            arr = arr2;
        }
    }
}
