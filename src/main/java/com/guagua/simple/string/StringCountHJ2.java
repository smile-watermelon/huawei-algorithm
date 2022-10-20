package com.guagua.simple.string;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/18 16:54
 * @describe 计算某字符出现次数
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * <p>
 * 数据范围： 1 ≤ n ≤ 1000
 * <p>
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 * <p>
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 */
public class StringCountHJ2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        String c;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            c = scanner.nextLine();

            char[] chars = line.toCharArray();
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (String.valueOf(chars[i]).toLowerCase().trim().equals(
                        c.trim().toLowerCase())) {
                    count++;
                }
            }
            System.out.println(count);
        }
        scanner.close();
        // 测试
        /*line = "aa vv";
        c = "a  ";
        System.out.println(charCount(line, c));*/
    }

    public static int charCount(String line, String c) {
        char[] chars = line.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (String.valueOf(chars[i]).trim().equals(c.trim())) {
                count++;
            }
        }
        return count;
    }
}
