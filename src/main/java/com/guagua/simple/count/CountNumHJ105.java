package com.guagua.simple.count;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/25 00:40
 * @describe HJ105 记负均正II
 *
 * 描述
 * 输入 n 个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 * 本题有多组输入数据，输入到文件末尾。
 *
 * 数据范围：1 \le n \le 50000 \1≤n≤50000  ，其中每个数都满足 |val| \le 10^{6} \∣val∣≤10
 * 6
 *
 * 输入描述：
 * 输入任意个整数，每行输入一个。
 *
 * 输出描述：
 * 输出负数个数以及所有非负数的平均值
 *
 * 示例1
 * 输入：
 * -13
 * -4
 * -7
 * 复制
 * 输出：
 * 3
 * 0.0
 * 复制
 * 示例2
 * 输入：
 * -12
 * 1
 * 2
 * 复制
 * 输出：
 * 1
 * 1.5
 *
 */
public class CountNumHJ105 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int i = 0;
        int count = 0;
        int zcount = 0;
        double sum = 0;

        while (scanner.hasNextInt()) {
             int i = scanner.nextInt();
            if (i < 0) {
                count++;
            } else {
                zcount++;
                sum += i;
            }
        }

        System.out.println(count);
        if (zcount==0) {
            System.out.println((double) 0);
        } else {
            System.out.println(String.format("%.1f", sum/zcount));
        }

    }
}
