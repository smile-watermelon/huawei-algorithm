package com.guagua.simple.string;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 12:06
 * @describe 数字颠倒
 * <p>
 * 描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * <p>
 * <p>
 * 数据范围： 0 \le n \le 2^{30}-1 \0≤n≤2
 * 30
 * −1
 * 输入描述：
 * 输入一个int整数
 * <p>
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 * <p>
 * 输入：1516000
 * 输出：0006151
 */
public class RevertStringHJ11 {

    public static void main(String[] args) {
        revertString();
    }

    private static void revertString() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if (i < 0) {
                System.out.println("请输入正确的参数");
                continue;
            }
            String str = String.valueOf(i);
            StringBuilder stringBuilder = new StringBuilder("");
            for (int j = str.length() - 1; j >= 0; j--) {
                stringBuilder.append(str.charAt(j));
            }
            System.out.println(stringBuilder);
        }
    }
}
