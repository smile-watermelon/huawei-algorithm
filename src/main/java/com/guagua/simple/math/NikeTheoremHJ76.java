package com.guagua.simple.math;

import com.guagua.hard.Test;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/25 14:57
 * @describe HJ76 尼科彻斯定理
 * <p>
 * 描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * <p>
 * 例如：
 * <p>
 * 1^3=1
 * <p>
 * 2^3=3+5
 * <p>
 * 3^3=7+9+11
 * <p>
 * 4^3=13+15+17+19
 * <p>
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 数据范围：1\le m\le 100\1≤m≤100
 * 进阶：时间复杂度：O(m)\O(m) ，空间复杂度：O(1)\O(1)
 * <p>
 * 输入描述：
 * 输入一个int整数
 * <p>
 * 输出描述：
 * 输出分解后的string
 * <p>
 * 示例1
 * 输入：
 * 6
 * 复制
 * 输出：
 * 31+33+35+37+39+41
 */
public class NikeTheoremHJ76 {

    /**
     * 本质是等差数列求第n项 这里 n = num
     * <p>
     * an = a1 + (n - 1)*d
     * Sn = (a1 + an) * n / 2
     * Sn = ((2a1 + (n - 1)*d) * n) /2;
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int sn = (int) Math.pow(n, 3);
            // 公差为2
            int tolerance = 2;

            int a1 = sn / n - (n - 1);

            StringBuilder res = new StringBuilder();
            res.append(a1);
            for (int i = 1; i < n; i++) {
                a1 += tolerance;
                res.append("+");
                res.append(a1);
            }
            System.out.println(res);

        }
    }
}
