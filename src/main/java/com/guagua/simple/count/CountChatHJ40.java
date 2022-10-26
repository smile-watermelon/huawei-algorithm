package com.guagua.simple.count;

import java.util.Base64;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author guagua
 * @date 2022/10/19 23:18
 * @describe  统计字符
 *
 * 描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 *
 * 输入描述：
 * 输入一行字符串，可以有空格
 *
 * 输出描述：
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 *
 * 示例1
 * 输入：
 * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 * 复制
 * 输出：
 * 26
 * 3
 * 10
 * 12
 */
public class CountChatHJ40 {
    public static void main(String[] args) {
//        m1();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            int c = 0;
            int blank = 0;
            int num = 0;
            int other = 0;
            for (int i = 0; i < str.length(); i++) {
                String s = String.valueOf(str.charAt(i));
                if (Pattern.compile("[A-Za-z]").matcher(s).find()) {
                    c++;
                } else if (Pattern.compile("[0-9]").matcher(s).find()) {
                    num++;
                } else if (Pattern.compile(" ").matcher(s).find()) {
                    blank++;
                }
            }
            other = str.length() - c - blank - num;
            System.out.println(c);
            System.out.println(blank);
            System.out.println(num);
            System.out.println(other);

        }
    }

    private static void m1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str=scanner.nextLine();
            String s1=str.replaceAll("[A-Z]+|[a-z]+", "");
            System.out.println(str.length()-s1.length());

            String s2=s1.replaceAll(" ", "");
            System.out.println(s1.length()-s2.length());

            String s3=s2.replaceAll("[0-9]+", "");
            System.out.println(s2.length()-s3.length()+"\n"+s3.length());
        }
    }
}
