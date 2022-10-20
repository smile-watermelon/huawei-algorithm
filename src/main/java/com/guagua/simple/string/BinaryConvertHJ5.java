package com.guagua.simple.string;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/18 22:11
 * @describe 进制转换
 * <p>
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * <p>
 * 数据范围：保证结果在 1 ≤ n ≤ 2^31-1
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 * <p>
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 */
public class BinaryConvertHJ5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String hex = scanner.nextLine();
            int i = Integer.parseInt(hex.trim().substring(2), 16);
            if (i < 0 || i > Integer.MAX_VALUE) {
                System.out.println("输入参数必须大于等于1并且小于" + Integer.MAX_VALUE);
                continue;
            }
            System.out.println(i);
        }
    }
}
