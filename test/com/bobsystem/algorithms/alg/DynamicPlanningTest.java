package com.bobsystem.algorithms.alg;

import org.junit.Test;

import java.util.Arrays;

public class DynamicPlanningTest {

    private final DynamicPlanning alg = new DynamicPlanning();

    @Test
    public void testCalc() {
        int tier = 10;
        int result = this.alg.calc(tier);
        System.out.printf("%d 级的楼梯每步走一级或两级，总共有 %d 种走法。", tier, result);
    }

    @Test
    public void testCalcOptimization() {
        int tier = 10;
        int result = this.alg.calcOptimization(tier);
        System.out.printf("%d 级的楼梯每步走一级或两级，总共有 %d 种走法。", tier, result);
    }

    @Test
    public void testCalcOptimization2() {
        int tier = 10;
        int result = this.alg.calcOptimization2(tier);
        System.out.printf("%d 级的楼梯每步走一级或两级，总共有 %d 种走法。", tier, result);
    }

    @Test
    public void testCalcMostGold() {
        // 金矿的储备量
        int[] mines = new int[] { 400, 500, 200, 300, 350 };
        // 各金矿对应的工人数
        int[] workmen = new int[] { 5, 5, 3, 4, 3 };
        // 金矿的数量
        int qty = mines.length;
        // 总工人数
        int workmenQty = 10;
        int result = this.alg.calcMostGold(mines, workmen, qty, workmenQty);
        System.out.printf(
            "各金矿的储备量为：%s%n" +
            "各金矿对应的工人数：%s%n" +
            "能挖取的金最多为：%d", Arrays.toString(mines), Arrays.toString(workmen), result);
    }
}
