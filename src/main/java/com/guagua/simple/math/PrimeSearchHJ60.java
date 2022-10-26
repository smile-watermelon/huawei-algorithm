package com.guagua.simple.math;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/26 00:52
 * @describe HJ60 查找组成一个偶数最接近的两个素数
 * <p>
 * 描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 * <p>
 * 数据范围：输入的数据满足 4 \le n \le 1000 \4≤n≤1000
 * 输入描述：
 * 输入一个大于2的偶数
 * <p>
 * 输出描述：
 * 从小到大输出两个素数
 * <p>
 * 示例1
 * 输入：
 * 20
 * 复制
 * 输出：
 * 7
 * 13
 * 复制
 * 示例2
 * 输入：
 * 4
 * 复制
 * 输出：
 * 2
 * 2
 */
public class PrimeSearchHJ60 {

    public static void main(String[] args) {

//        System.out.println(Math.sqrt(4));
//        System.out.println(Math.sqrt(7));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            solution(num);
        }
    }

    private static void solution(int num) {
        //如num=10, 遍历:5,6,7,8
        // 从最接近的两个中位数开始处理判断
        for (int i = num / 2; i < num - 1; i++) {
            if (isPrime(i) && isPrime(num - i)) {
                System.out.println((num - i) + "\n" + i);
                return;
            }
        }
    }

    // 判断是否素数
    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) { // todo 这里为什么要开根
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
