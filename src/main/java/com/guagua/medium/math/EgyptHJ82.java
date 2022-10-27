package com.guagua.medium.math;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/27 16:56
 * @describe HJ82 将真分数分解为埃及分数
 *
 * 描述
 * 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
 * 注：真分数指分子小于分母的分数，分子和分母有可能gcd不为1！
 * 如有多个解，请输出任意一个。
 *
 *
 * 输入描述：
 * 输入一个真分数，String型
 *
 * 输出描述：
 * 输出分解后的string
 *
 * 示例1
 * 输入：
 * 8/11
 * 2/4
 * 复制
 * 输出：
 * 1/2+1/5+1/55+1/110
 * 1/3+1/6
 * 复制
 * 说明：
 * 第二个样例直接输出1/2也是可以的
 */
public class EgyptHJ82 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
        }
    }
}
