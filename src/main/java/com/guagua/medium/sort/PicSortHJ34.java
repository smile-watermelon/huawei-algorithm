package com.guagua.medium.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/21 02:28
 * @describe 图片整理
 * <p>
 * 描述
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过代码解决。
 * Lily使用的图片使用字符"A"到"Z"、"a"到"z"、"0"到"9"表示。
 * <p>
 * 数据范围：每组输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 * <p>
 * 输入描述：
 * 一行，一个字符串，字符串中的每个字符表示一张Lily使用的图片。
 * <p>
 * 输出描述：
 * Lily的所有图片按照从小到大的顺序输出
 * <p>
 * 示例1
 * 输入：
 * Ihave1nose2hands10fingers
 * 复制
 * 输出：
 * 0112Iaadeeefghhinnnorsssv
 */
public class PicSortHJ34 {


    public static void main(String[] args) {
//        m1();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            char c;
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars.length - i - 1; j++) {
                    if (chars[j] - chars[j+1] > 0) {
                        c = chars[j];
                        chars[j] = chars[j+1];
                        chars[j+1] = c;
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                result.append(chars[i]);
            }
            System.out.println(result);
        }
    }

    private static void m1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            char[] chars = next.toCharArray();
            Arrays.sort(chars);
            System.out.println(String.valueOf(chars));
        }
    }

}
