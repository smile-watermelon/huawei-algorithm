package com.guagua.simple.math;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/26 00:34
 * @describe HJ56 完全数计算
 * <p>
 * 描述
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * <p>
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * <p>
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 * <p>
 * 输入n，请输出n以内(含n)完全数的个数。
 * <p>
 * 数据范围： 1 \le n \le 5 \times 10^{5} \1≤n≤5×10
 * 5
 * <p>
 * 输入描述：
 * 输入一个数字n
 * <p>
 * 输出描述：
 * 输出不超过n的完全数的个数
 * <p>
 * 示例1
 * 输入：
 * 1000
 * 复制
 * 输出：
 * 3
 */
public class PerfectNumberHJ56 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();

            //第一个完全数是6，若小于6则输出0
            if (n < 6) {
                System.out.println(0);
                continue;
            }

            int count = 0;    //计数变量
            for (int t = 6; t <= n; t++) {
                int sum = 0;
                //统计因数的和，计数到该数的1/2即可, 最大真因数不会超过 t 的 1/2
                for (int i = 1; i <= t / 2; i++) {
                    if (t % i == 0)
                        sum += i;
                }
                if (sum == t)
                    count++;
            }

            //输出结果
            System.out.println(count);
        }
    }
}
