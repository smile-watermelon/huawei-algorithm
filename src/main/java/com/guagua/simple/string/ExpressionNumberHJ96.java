package com.guagua.simple.string;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/23 22:15
 * @describe HJ96 表示数字
 *
 * 描述
 * 将一个字符串中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
 *
 *
 * 数据范围：字符串长度满足 1 \le n \le 100 \1≤n≤100
 * 输入描述：
 * 输入一个字符串
 *
 * 输出描述：
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 *
 * 示例1
 * 输入：
 * Jkdi234klowe90a3
 *
 * 输出：
 * Jkdi*234*klowe*90*a*3*
 */
public class ExpressionNumberHJ96 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            String s = next.replaceAll("([0-9]+)", "*$1*");
            System.out.println(s);

        }
    }
}
