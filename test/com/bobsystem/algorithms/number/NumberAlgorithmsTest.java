package com.bobsystem.algorithms.number;

import org.junit.Test;

public class NumberAlgorithmsTest {

    private final NumberAlgorithms numberAlgorithms = new NumberAlgorithms();

    /**
     * 素数/质数，在大于 1 的自然数中，除了 1 和 它本身 以外不再有其他因数的数称为质数
     */
    @Test
    public void testShowPrime() {
        NumberAlgorithms alg = this.numberAlgorithms;
        final int max = 105;
        alg.showPrime(max);
        System.out.println();

        alg.showPrimeFilter(max);
    }

    /**
     * 99 乘法表
     */
    @Test
    public void testMultiplyTable() {
        this.numberAlgorithms.multiplyTable();
    }

    /**
     * 对称数
     */
    @Test
    public void testCircleNumber() {

        for (int i = 20; i < 300; ++i) {

            if (this.numberAlgorithms.isCircleNumber(i)) {

                System.out.printf("%d ", i);
            }
        }
    }

    /**
     * 50人 谁数到3 谁就离开
     */
    @Test
    public void testCycleDelete() {
        this.numberAlgorithms.cycleDelete(50, 3);
    }

    /**
     * 阿姆斯特朗数，当幂是3时称为 [水仙花数]
     */
    @Test
    public void testArmstrongNumber() {
        this.numberAlgorithms.armstrongNumber(0, 500);
    }
}
