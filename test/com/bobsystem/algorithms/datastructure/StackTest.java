package com.bobsystem.algorithms.datastructure;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private final Stack<Integer> stack = new Stack<Integer>();

    @Before
    public void init() {

        this.stack.push(0);
        this.stack.push(1);
        this.stack.push(2);
        this.stack.push(3);
    }

    @Test
    public void testPushPop() {

        System.out.println(this.stack.push(4));

        System.out.println(this.stack.pop());
        System.out.println(this.stack.pop());

        System.out.println(this.stack);
    }

    @Test
    public void testClear() {

        System.out.println(this.stack);

        this.stack.clear();
        System.out.println(this.stack);

        this.stack.push(0);
        System.out.println(this.stack);
    }

    @Test
    public void testIsEmptyOrFull() {

        System.out.println(this.stack.isEmpty());
        System.out.println(this.stack.isFull());

        this.stack.pop();

        System.out.println(this.stack.isEmpty());
        System.out.println(this.stack.isFull());

        this.stack.clear();

        System.out.println(this.stack.isEmpty());
        System.out.println(this.stack.isFull());
    }

    // 使用 Stack 进行进制转换
    @Test
    public void testConvert() {

        calculator(2016, 2); // binary

        calculator(10, 8); // octonary

        calculator(2016, 12);

        calculator(48, 16); // hexadecimal
    }

    private void calculator(int number, int radix) {

        Stack<Character> stack = new Stack<Character>(10);

        int ret = number;
        while (ret != 0) {

            int mod = ret % radix;
            if (mod >= 10) {
                stack.push((char)(mod + 55));
            }
            else {
                stack.push((char)(mod + 48));
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
    }

    /**
     * 使用 Stack 进行括号匹配
     */
    @Test
    public void testMatchBrackets() {

        String brackets = "{{[(){}]}";
        String left = "{[("; // left 和 right 从前往后要对应，依靠括号在它们中的索引判断是否匹配
        String right = "}])";

        Stack<Character> stack = new Stack<Character>(10); // 目标代码中出现的左括号

        boolean isMatch = true;

        for (int i = 0, c = brackets.length(); i < c; ++i) {

            char ch = brackets.charAt(i);
            if (left.indexOf(ch) != -1) { // 所有的左括号包含 指定的括号
                stack.push(ch);
                continue;
            }
            // 不在左括号集合中，判定为右括号
            Character top = stack.pop();
            if (top == null ||           // 右侧括号多于左侧时，top 可能为null
                left.indexOf(top) != right.indexOf(ch)) { // 判断左括号top 与 右括号ch在 left 和 right 中的索引

                isMatch = false;
                break;
            }
        }
        if (isMatch && stack.isEmpty()) {
            System.out.println("match..");
        }
        else {
            System.out.println("not match..");
        }
    }
}
