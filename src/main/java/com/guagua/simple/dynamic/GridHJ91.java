package com.guagua.simple.dynamic;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/25 18:06
 * @describe HJ91 走方格的方案数
 * <p>
 * 描述
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 * <p>
 * 注：沿棋盘格之间的边缘线行走
 * <p>
 * 数据范围： 1 \le n,m \le 8 \1≤n,m≤8
 * <p>
 * <p>
 * 输入描述：
 * 输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
 * <p>
 * 输出描述：
 * 输出一行结果
 * <p>
 * 示例1
 * 输入：
 * 2 2
 * 复制
 * 输出：
 * 6
 */
public class GridHJ91 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int c = cal(m, n);
            System.out.println(c);
        }
    }

    public static int cal(int m, int n) {
        if (m == 1 || n == 1) {
            return m + n;

        }
        return cal(m - 1, n) + cal(m, n - 1);
    }
}
