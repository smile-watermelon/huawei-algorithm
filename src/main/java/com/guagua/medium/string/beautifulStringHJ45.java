package com.guagua.medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author guagua
 * @date 2022/10/21 20:09
 * @describe HJ45 名字的漂亮度
 * <p>
 * 描述
 * 给出一个字符串，该字符串仅由小写字母组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
 * <p>
 * 给出多个字符串，计算每个字符串最大可能的“漂亮度”。
 * <p>
 * 本题含有多组数据。
 * <p>
 * 数据范围：输入的名字长度满足 1 \le n \le 10000 \1≤n≤10000
 * <p>
 * 输入描述：
 * 第一行一个整数N，接下来N行每行一个字符串
 * <p>
 * 输出描述：
 * 每个字符串可能的最大漂亮程度
 * <p>
 * 示例1
 * 输入：
 * 2
 * zhangsan
 * lisi
 * 复制
 * 输出：
 * 192
 * 101
 * 复制
 * 说明：
 * 对于样例lisi，让i的漂亮度为26，l的漂亮度为25，s的漂亮度为24，lisi的漂亮度为25+26+24+26=101.
 */
public class beautifulStringHJ45 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int rows = scanner.nextInt();
            for (int i = 0; i < rows; i++) {
                String str = scanner.next();
                int[] ints = new int[26];
                for (int j = 0; j < str.length(); j++) {
                    ints[str.charAt(j) - 'a']++;
                }
                Arrays.sort(ints);
                int sum = 0;
                int maxValue = 26;
                for (int j = ints.length - 1; j >= 0 && ints[j] > 0; j--) {
                    sum += ints[j] * maxValue;
                    maxValue--;
                }
                System.out.println(sum);
            }
        }

    }
}
