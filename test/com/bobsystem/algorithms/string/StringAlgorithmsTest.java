package com.bobsystem.algorithms.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class StringAlgorithmsTest {

    private final StringAlgorithms algorithm = new StringAlgorithms();

    @Test
    public void testMoney2Hanzi() {
        System.out.println(this.algorithm.money2Hanzi(100001));
        System.out.println(this.algorithm.money2Hanzi(1000000001.));
        System.out.println(this.algorithm.money2Hanzi(1030405670));
        System.out.println(this.algorithm.money2Hanzi(1030405675.4001));
        System.out.println(this.algorithm.money2Hanzi(1030405675.1234));
    }

    @Test
    public void testMoney2Hanzi2() {
        System.out.println(this.algorithm.money2Hanzi2(100001));
        System.out.println(this.algorithm.money2Hanzi2(1000000001.));
        System.out.println(this.algorithm.money2Hanzi2(1030405670));
        System.out.println(this.algorithm.money2Hanzi2(1030405675.4001));
        System.out.println(this.algorithm.money2Hanzi2(1030405675.1234));
    }

    @Test
    public void testComplementSubstring() {

        String str = "刘ab少cd波";

        try {
            byte bytes[] = str.getBytes("utf-8");

            for (int subLength = 1; subLength < 7; ++subLength) {

                String result = this.algorithm.complementSubstring(bytes, subLength);
                System.out.println(result);
            }
        }
        catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
}
