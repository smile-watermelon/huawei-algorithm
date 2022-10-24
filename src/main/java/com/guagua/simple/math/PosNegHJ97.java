package com.guagua.simple.math;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/25 01:04
 * @describe HJ97 记负均正
 * <p>
 * 描述
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 0即不是正整数，也不是负数，不计入计算。如果没有正数，则平均值为0。
 * <p>
 * 数据范围： 1 \le n\ \le 2000 \1≤n ≤2000  ，输入的整数都满足 |val| \le 1000 \∣val∣≤1000
 * 输入描述：
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 * <p>
 * 输出描述：
 * 输出负数的个数，和所有正整数的平均值。
 * <p>
 * 示例1
 * 输入：
 * 11
 * 1 2 3 4 5 6 7 8 9 0 -1
 * 复制
 * 输出：
 * 1 5.0
 * 复制
 * 示例2
 * 输入：
 * 3
 * 0 0 0
 * 复制
 * 输出：
 * 0 0.0
 */
public class PosNegHJ97 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int zcount = 0;
        int sum = 0;
        double avg = 0;
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                if (num < 0) {
                    count++;
                } else if (num > 0) {
                    zcount++;
                    sum += num;
                }
            }
        }
        if (zcount != 0) {
            avg = sum * 1.0 / zcount;
        }
        System.out.println(count + " " + String.format("%0.1f", avg));
    }
}
