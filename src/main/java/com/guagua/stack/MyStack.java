package com.guagua.stack;

import java.util.Arrays;
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
        if (day>0) {
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
}
