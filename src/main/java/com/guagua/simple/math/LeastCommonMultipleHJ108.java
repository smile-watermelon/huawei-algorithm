package com.guagua.simple.math;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 22:08
 * @describe 求最小公倍数
 * <p>
 * 描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * <p>
 * 数据范围：1 \le a,b \le 100000 \1≤a,b≤100000
 * 输入描述：输入两个正整数A和B。
 * <p>
 * 输出描述：输出A和B的最小公倍数。
 * <p>
 * 示例1
 * 输入：5 7
 * <p>
 * 输出：35
 * <p>
 * 示例2
 * 输入：2 4
 * <p>
 * 输出：4
 * <p>
 * 复制
 */
public class LeastCommonMultipleHJ108 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int c = x;
            int result = recursion(x, y, c);
            System.out.println(result);
        }
    }

    public static int recursion(int x, int y, int c) {
        if (x % y == 0) { // x累加过程中永远可以整除自身，所以可以整除b时就是最小公倍数！
            return x;
        }
        return recursion(x + c, y, c);
    }

}
