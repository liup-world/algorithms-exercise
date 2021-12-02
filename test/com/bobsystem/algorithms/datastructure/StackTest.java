package com.bobsystem.algorithms.datastructure;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private final Stack<Integer> stack = new Stack<>();

    @Before
    public void init() {
        Stack<Integer> stack = this.stack;
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void testPushPop() {
        Stack<Integer> stack = this.stack;
        System.out.println(stack.push(4));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    @Test
    public void testClear() {
        Stack<Integer> stack = this.stack;
        System.out.println(stack);
        this.stack.clear();
        System.out.println(stack);
        this.stack.push(0);
        System.out.println(stack);
    }

    @Test
    public void testIsEmptyOrFull() {
        Stack<Integer> stack = this.stack;
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        this.stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        this.stack.clear();
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
    }

    /**
     * 使用 Stack 进行括号匹配。实现逻辑：
     *   遇到将左括号放入栈，遇到右括号，弹出栈顶，比对左右括号是否是一对。
     */
    @Test
    public void testMatchBrackets() {
        String brackets = "{{[( a value ) { second value }]}";
        String left = "{[("; // left 和 right 从前往后要对应，依靠括号在它们中的索引判断是否匹配
        String right = "}])";

        Stack<Character> stack = new Stack<>(10); // 目标代码中出现的左括号
        boolean isMatch = true;
        for (char ch : brackets.toCharArray()) {
            if (left.indexOf(ch) != -1) { // 所有的左括号包含 指定的括号
                stack.push(ch);
                continue;
            }
            if (right.indexOf(ch) == -1) continue; // 路过非右括号字符
            // 不在左括号集合中，判定为右括号
            Character top = stack.pop();
            // 右侧括号多于左侧时，top 可能为 null
            if (top == null ||
                // 判断左括号 top 与 右括号 ch，在 left 和 right 中的索引是否一致
                left.indexOf(top) != right.indexOf(ch)) {
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
