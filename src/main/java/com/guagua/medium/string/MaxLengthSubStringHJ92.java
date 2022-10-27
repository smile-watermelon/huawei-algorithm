package com.guagua.medium.string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/20 20:08
 * @describe 在字符串中找出连续最长的数字串
 * <p>
 * 描述
 * 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
 * 本题含有多组样例输入。
 * <p>
 * 数据范围：字符串长度 1 \le n \le 200 \1≤n≤200  ， 保证每组输入都至少含有一个数字
 * 输入描述：
 * 输入一个字符串。1<=len(字符串)<=200
 * <p>
 * 输出描述：
 * 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。
 * <p>
 * 示例1
 * 输入：
 * abcd12345ed125ss123058789
 * a8a72a6a5yy98y65ee1r2
 * <p>
 * 输出：
 * 123058789,9
 * 729865,2
 * 说明：
 * 样例一最长的数字子串为123058789，长度为9
 * 样例二最长的数字子串有72,98,65，长度都为2
 */
public class MaxLengthSubStringHJ92 {

    public static void main(String[] args) {
        m();
    }

    private static void m() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] numbs = str.split("[^0-9]+");
            int len = 0;
            StringBuilder result = new StringBuilder();
            for (String numb : numbs) {
                if (numb.length() > len) {
                    len = numb.length();
                    result = new StringBuilder(numb);
                } else if (len == numb.length()) {
                    result.append(numb);
                }
            }
            System.out.println(result + "," + len);
        }
    }
}
