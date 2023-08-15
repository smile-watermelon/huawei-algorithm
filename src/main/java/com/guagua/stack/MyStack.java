package com.guagua.stack;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;
import java.util.Stack;

/**
 * @author guagua
 * @date 2022/11/29 17:39
 * @describe
 */
public class MyStack {

    public static int mock(int day, int remain) {
//        int x = 0;
//        int last = 10;
        if (day > 0) {
            remain += (remain + 1) * 2;
            mock(--day, remain);
        }
        return remain;
    }

    public static void main(String[] args) {
        int mock = mock(10, 1);
        System.out.println(mock);

//        // 压入数据 0，3，1，5，2
//        int[] arr = {0, 3, 1, 5, 2};
//        Arrays.sort(arr);
//        Stack<Integer> stack = new Stack<>();
//        for (int i : arr) {
//            stack.push(i);
//            System.out.println(i);
//        }
//
////        Integer pop = stack.pop();
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }


    }

    @Test
    public void stack() {
        /**
         * 在java中，Stack 类继承了Vector 类，并实现了5个方法，分别为：
         * push 压栈
         * pop 出栈
         * peek 查看栈顶元素，不从栈里删除
         * empty 检查栈是否为空
         * search 搜索元素，返回距离栈顶的距离
         * 在使用栈是，官方不推荐直接使用该类，而是使用Deque 例如：
         * Deque<Integer> stack = new ArrayDeque<>();
         */
//        Stack<Object> stack = new Stack<>();
        ArrayQueue<Integer> stack = new ArrayQueue<>(10000);
        stack.add(1);

    }
}
