package com.bobsystem.algorithms;

import org.junit.Test;

public class BitArithmeticTest {

    @Test
    public void test() {

        int i = 5; // 101
        int j = 3; // 011

        i ^= j; // 110
        j ^= i; // 101
        i ^= j; // 011

        System.out.println(i);
        System.out.println(j);
    }
}
