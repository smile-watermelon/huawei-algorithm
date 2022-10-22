package com.guagua.simple.math;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/21 22:43
 * @describe HJ100 等差数列
 * <p>
 * 描述
 * 等差数列 2，5，8，11，14。。。。
 * （从 2 开始的 3 为公差的等差数列）
 * 输出求等差数列前n项和
 * <p>
 * <p>
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000
 * 输入描述：
 * 输入一个正整数n。
 * <p>
 * 输出描述：
 * 输出一个相加后的整数。
 * <p>
 * 示例1
 * 输入：
 * 2
 * 输出：
 * 7
 * 说明：
 * 2+5=7
 * 示例2
 * 输入：
 * 275
 * 复制
 * 输出：
 * 113575
 * 复制
 * 说明：
 * 2+5+...+821+824=113575
 */
public class ArithmeticHJ100 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            // an = a1 + (n -1) * d
            // Sn = (a1 + an ) * n / 2;
            int a1 = 2;
            int d = 3;
            int an = a1 + (n - 1) * d;
            int Sn = (a1 + an) * n / 2;
            System.out.println(Sn);
        }
    }
}
