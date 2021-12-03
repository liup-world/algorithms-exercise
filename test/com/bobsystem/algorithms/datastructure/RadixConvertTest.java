package com.bobsystem.algorithms.datastructure;

import org.junit.Test;

/**
 * 使用 Stack 进行进制转换
 */
public class RadixConvertTest {

    @Test
    public void testConvert() {
        calculator(2016, 2); // binary
        calculator(10, 8); // octonary
        calculator(2016, 12);
        calculator(63, 16); // hexadecimal
    }

    private void calculator(int number, int radix) {
        Stack<Character> stack = new Stack<>(10);
        int ret = number;
        while (ret != 0) {
            int mod = ret % radix;
            if (mod >= 10) { // 说明正在转换为 十六进制
                stack.push((char)(mod + 55)); // 目的是将数值 10~15 转换为 A~F
            }
            else {
                stack.push((char)(mod + 48)); // 目的是将数值 0~9 转换为字符 '0'~'9'
            }
            ret /= radix;
        }
        for (int i = 0; i < 10; ++i) {
            Character tmp = stack.pop();
            if (tmp != null) {
                System.out.print(tmp);
            }
        }
        System.out.println();
        //System.out.println(joinStrArray(stack.toArray(), ""));
    }

    private String joinStrArray(Object[] arr, String separator) {
        StringBuilder strBuilder = new StringBuilder(20);
        for (int i = arr.length - 1; i >= 0; --i) {
            Object ch = arr[i];
            if (ch == null) continue;
            strBuilder.append(ch).append(separator);
        }
        return strBuilder.toString();
    }
}
