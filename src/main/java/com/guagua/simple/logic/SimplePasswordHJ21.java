package com.guagua.simple.logic;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 17:36
 * @describe 简单密码
 * <p>
 * 描述
 * 现在有一种密码变换算法。
 * 九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，
 * 把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.
 * 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
 * 数字和其它的符号都不做变换。
 * 数据范围： 输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
 * 输入描述：
 * 输入一组密码，长度不超过100个字符。
 * <p>
 * 输出描述：输出密码变换后的字符串
 * <p>
 * 示例1
 * 输入：YUANzhi1987
 * <p>
 * 输出：zvbo9441987
 */
public class SimplePasswordHJ21 {
    public static void main(String[] args) {
        System.out.println((int) 'A'); // 65
        System.out.println((int) 'Z'); // 90
        System.out.println((int) 'a'); // 97
        System.out.println((int) 'z'); // 122
        main1();
    }

    public static void main1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String plain = scanner.next();
            StringBuilder builder = new StringBuilder("");
            for (int i = 0; i < plain.length(); i++) {
                char c = plain.charAt(i);
                if (c >= 'A' && c < 'Z') { // 判断是不是大写
                    char newChar= (char) (c + 32 + 1);
                    builder.append(newChar);

                } else if (c == 'Z') {
                    builder.append("a");
                } else if (c >= 'a' && c <= 'z') { // 小写转换为数字
                    int num = 0;
                    if ("abc".contains(String.valueOf(c))) {
                        num = 2;
                    } else if ("def".contains(String.valueOf(c))) {
                        num = 3;
                    } else if ("ghi".contains(String.valueOf(c))) {
                        num = 4;
                    } else if ("jkl".contains(String.valueOf(c))) {
                        num = 5;
                    } else if ("mno".contains(String.valueOf(c))) {
                        num = 6;
                    } else if ("pqrs".contains(String.valueOf(c))) {
                        num = 7;
                    } else if ("tuv".contains(String.valueOf(c))) {
                        num = 8;
                    } else if ("wxyz".contains(String.valueOf(c))) {
                        num = 9;
                    }
                    builder.append(num);
                } else {
                    builder.append(c);
                }
            }
            System.out.println(builder);
        }
    }
}
