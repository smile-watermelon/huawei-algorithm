package com.guagua.simple.count;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/25 14:41
 * @describe HJ62 查找输入整数二进制中1的个数
 * <p>
 * 描述
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 * <p>
 * 数据范围： 1 \le n \le 2^{31}-1 \1≤n≤2
 * 31
 * −1
 * 输入描述：
 * 输入一个整数
 * <p>
 * 输出描述：
 * 计算整数二进制中1的个数
 * <p>
 * 示例1
 * 输入：
 * 5
 * 复制
 * 输出：
 * 2
 * 复制
 * 说明：
 * 5的二进制表示是101，有2个1
 * 示例2
 * 输入：
 * 0
 * 复制
 * 输出：
 * 0
 */
public class BitCountHJ62 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int count = 0;
            while (num != 0) {
                count += num & 1;
                num >>= 1;
            }

            System.out.println(count);
        }
    }
}
