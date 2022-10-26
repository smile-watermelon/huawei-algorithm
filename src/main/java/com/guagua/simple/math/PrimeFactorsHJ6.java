package com.guagua.simple.math;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/18 22:27
 * @describe 质数因子
 * <p>
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * 数据范围：1 ≤ n ≤ 2×10^9 + 14
 * <p>
 * 输入描述：
 * 输入一个整数
 * <p>
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 * <p>
 * 示例1 输入：180
 * 输出：2 2 3 3 5
 */
public class PrimeFactorsHJ6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int y = 2;

            while (num != 1) {
                if (num % y == 0) {
                    System.out.print(y + " ");
                    num /= y;
                } else {
                    if (y > num / y) { // 除不尽，无法对y 取余 所以将y 得值 设置为num 下一次除尽。例如 num = 5, y = 3
                        y = num;
                    } else {
                        y++;
                    }
                }
            }
        }
    }
}
