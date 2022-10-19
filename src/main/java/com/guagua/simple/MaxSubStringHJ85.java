package com.guagua.simple;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 21:51
 * @describe 最长回文子串
 * <p>
 * 描述
 * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
 * 所谓回文串，指左右对称的字符串。
 * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
 * 数据范围：字符串长度1\le s\le 350\1≤s≤350
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入一个仅包含小写字母的字符串
 * <p>
 * 输出描述：
 * 返回最长回文子串的长度
 * <p>
 * 示例1
 * 输入：cdabbacc
 * 输出：4
 * 说明：abba为最长的回文子
 */
public class MaxSubStringHJ85 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            int max = 0;
            for (int i = 0; i < str.length(); i++) {
                for (int j = str.length(); j > i; j--) {
                    String subStr = str.substring(i, j);
                    if (subStr.equals(new StringBuilder(subStr).reverse().toString())) {
                        max = Math.max(max, j - i);
                    }
                }
            }
            System.out.println(max);
        }
    }
}