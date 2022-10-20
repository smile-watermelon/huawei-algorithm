package com.guagua.medium.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/20 14:47
 * @describe 字符串排序
 * <p>
 * 描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * <p>
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * <p>
 * 如，输入： Type 输出： epTy
 * <p>
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * <p>
 * 如，输入： BabA 输出： aABb
 * <p>
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * <p>
 * 如，输入： By?e 输出： Be?y
 * <p>
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 * <p>
 * 输入描述：输入字符串
 * <p>
 * 输出描述：输出字符串
 * <p>
 * 示例1
 * 输入：A Famous Saying: Much Ado About Nothing (2012/8).
 * <p>
 * 输出：A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class StringSortHJ26 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();

            String strSorted = sort(str);
            System.out.println(strSorted);
        }
    }

    private static String sort(String str) {
        ArrayList<Character> letters = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                letters.add(c);
            }
        }
        // 用小写排序为了保证排序后字符大小写的顺序
        letters.sort(Comparator.comparingInt(Character::toLowerCase));

        StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result.append(letters.get(j++));
            } else {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }
}
