package com.guagua.medium.string;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/21 00:36
 * @describe 公共子串计算
 * <p>
 * 描述
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * <p>
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 * 数据范围：字符串长度：1\le s\le 150\1≤s≤150
 * 进阶：时间复杂度：O(n^3)\O(n
 * 3
 * ) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入两个只包含小写字母的字符串
 * <p>
 * 输出描述：
 * 输出一个整数，代表最大公共子串的长度
 * <p>
 * 示例1
 * 输入：
 * asdfas
 * werasdfaswer
 * 复制
 * 输出：
 * 6
 */
public class CommonSubStringHJ75 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String strA = scanner.next();
            String strB = scanner.next();

            int strALen = strA.length();
            int strBLen = strB.length();

            String small = strALen < strBLen ? strA : strB;
            String big = strALen < strBLen ? strB : strA;

            int smallLen = small.length();
            int bigLen = big.length();
            int len = 0;
            int[] index = new int[2];
            for (int i = 0; i < smallLen; i++) {
                for (int j = smallLen; j > i; j--) {
                    if (big.contains(small.substring(i, j))) {
                        len = Math.max(j - i, len);
//                        index[0] = i;
//                        index[1] = j;
//                        System.out.println(len);
                        break;
                    }
                }
            }
//            System.out.println(small.substring(index[0], index[1]));
//            System.out.println(index[1] - index[0]);
            System.out.println(len);
        }
    }
}
