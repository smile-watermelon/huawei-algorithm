package com.guagua.low;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 16:04
 * @describe 输入n个整数，输出其中最小的k个
 * <p>
 * 描述
 * 输入n个整数，找出其中最小的k个整数并按升序输出
 * <p>
 * 本题有多组输入样例
 * <p>
 * 数据范围：1 \le n \le 1000 \1≤n≤1000  ，输入的整数满足 1 \le val \le 10000 \1≤val≤10000
 * 输入描述：
 * 第一行输入两个整数n和k
 * 第二行输入一个整数数组
 * <p>
 * 输出描述：
 * 从小到大输出最小的k个整数，用空格分开。
 * <p>
 * 示例1
 * 输入：5 2
 * 1 3 5 7 2
 * <p>
 * 输出：1 2
 */
public class ExtractMinNumbersHJ58 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int need = scanner.nextInt();

        int[] sorted = new int[total];

        for (int i = 0; i < total; i++) {
            int num = scanner.nextInt();
            sorted[i] = num;
        }

        // 使用冒泡排序
        int t;
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - 1 - i; j++) {
                if (sorted[j] > sorted[j +1]) {
                    t = sorted[j];
                    sorted[j] = sorted[j +1];
                    sorted[j +1] = t;
                }
            }
        }

        for (int i = 0; i < need; i++) {
            System.out.print(sorted[i] + " ");
        }
    }
}
