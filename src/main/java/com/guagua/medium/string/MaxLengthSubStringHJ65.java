package com.guagua.medium.string;

import java.time.OffsetDateTime;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/20 21:36
 * @describe 查找两个字符串a, b中的最长公共子串
 * <p>
 * 描述
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
 * <p>
 * 数据范围：字符串长度1\le length \le300 \1≤length≤300
 * 进阶：时间复杂度：O(n^3)\O(n
 * 3
 * ) ，空间复杂度：O(n)\O(n)
 * 输入描述：输入两个字符串
 * <p>
 * 输出描述：返回重复出现的字符
 * <p>
 * 示例1
 * 输入：
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * <p>
 * 输出：jklmnop
 */
public class MaxLengthSubStringHJ65 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(comStr(sc.nextLine(), sc.nextLine()));
        }
        sc.close();
    }

    public static String comStr(String str1, String str2) {
        String small = str1.length() < str2.length() ? str1 : str2;
        String big = str1.length() < str2.length() ? str2 : str1;
        int len = 0;
        int[] index = new int[2];
        for (int i = 0; i < small.length(); i++) {
            // substring是截取从i到j-1的字符，j-i是数量所以需要+1，那么直接取small.length()的长度
            for (int j = small.length(); j > i; j--) {
                if (big.contains(small.substring(i, j)) && j - i > len) { // 双指针从后往前遍历，只要出现j -i > len 就是最大子串
                    len = j - i;
                    // 保存最大的公共字符串的指针下标
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }
        return small.substring(index[1], index[0]);
    }

}
