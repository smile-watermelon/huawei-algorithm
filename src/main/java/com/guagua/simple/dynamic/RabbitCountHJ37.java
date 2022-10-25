package com.guagua.simple.dynamic;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/25 23:27
 * @describe HJ37 统计每个月兔子的总数
 * <p>
 * 描述
 * 有一种兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子。
 * 例子：假设一只兔子第3个月出生，那么它第5个月开始会每个月生一只兔子。
 * 一月的时候有一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
 * 数据范围：输入满足 1 \le n \le 31 \1≤n≤31
 * 输入描述：
 * 输入一个int型整数表示第n个月
 * <p>
 * 输出描述：
 * 输出对应的兔子总数
 * <p>
 * 示例1
 * 输入：
 * 3
 * 复制
 * 输出：
 * 2
 */
public class RabbitCountHJ37 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(dp(n));
        }
    }

    public static int dp(int n) {
        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 1;
        for (int i = 3; i <= n; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[n];
    }
}
