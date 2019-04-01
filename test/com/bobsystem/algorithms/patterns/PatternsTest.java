package com.bobsystem.algorithms.patterns;

import org.junit.Test;

// 打印图案测试
public class PatternsTest {

    private final PatternAlgorithms algorithm = new PatternAlgorithms();

    // 打印等腰三角形
    @Test
    public void testPrintTriangle() {
        this.algorithm.printTriangle(5);
    }

    // 打印菱形
    @Test
    public void testPrintRhombus() {
        this.algorithm.printRhombus(10);
    }

    // 打印 杨辉三角形，又称贾宪三角形，帕斯卡三角形
    @Test
    public void printPascalsTriangle() {
        this.algorithm.printPascalsTriangle(13);
    }
}
