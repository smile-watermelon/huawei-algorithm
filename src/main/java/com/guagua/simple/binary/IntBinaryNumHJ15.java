package com.guagua.simple.binary;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 14:19
 * @describe 求int型正整数在内存中存储时1的个数
 * <p>
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 * <p>
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 * 输入一个整数（int类型）
 * <p>
 * 输出描述：
 * 这个数转换成2进制后，输出1的个数
 * 示例1
 * 输入：5
 * 输出：2
 */
public class IntBinaryNumHJ15 {

    public static void main(String[] args) {
//        [0,1,2,3]
//        m1();
//        m2();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            String s = Integer.toBinaryString(num);
            String s1 = s.replaceAll("1", "");
            System.out.println(s.length() - s1.length());
        }
    }

    private static void m2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int[] result = new int[num + 1];
            for (int i = 1; i <= num; ++i) {
                result[i] = result[i >> 1] + (i & 1);
            }
            System.out.println(result[num]);
        }
    }

    private static void m1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int[] result = new int[num + 1];
            for (int i = 1; i <= num; ++i) {
                result[i] = result[i & (i - 1)] + 1;
            }
            System.out.println(result[num]);
        }
    }
}
