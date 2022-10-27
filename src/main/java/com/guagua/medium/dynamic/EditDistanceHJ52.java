package com.guagua.medium.dynamic;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/26 00:59
 * @describe HJ52 计算字符串的编辑距离
 * <p>
 * 描述
 * Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。编辑距离的算法是首先由俄国科学家 Levenshtein 提出的，故又叫 Levenshtein Distance 。
 * <p>
 * 例如：
 * <p>
 * 字符串A: abcdefg
 * <p>
 * 字符串B: abcdef
 * <p>
 * 通过增加或是删掉字符 ”g” 的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
 * <p>
 * 要求：
 * <p>
 * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
 * <p>
 * <p>
 * 数据范围：给定的字符串长度满足 1 \le len(str) \le 1000 \1≤len(str)≤1000
 * <p>
 * <p>
 * 输入描述：
 * 每组用例一共2行，为输入的两个字符串
 * <p>
 * 输出描述：
 * 每组用例输出一行，代表字符串的距离
 * <p>
 * 示例1
 * 输入：
 * abcdefg
 * abcdef
 * 复制
 * 输出：
 * 1
 */
public class EditDistanceHJ52 {

    /**
     * Java版本,看到字符串修改代价第一时间想到动态规划
     * A[0,...i-1]最后修改为B[0,...j-1]，有以下两种情况：
     * （一）A[i-1] == B[j-1]时，最后一个元素不用动，只用考虑A[0,...i-2]编辑为B[0,...j-2]需要的代价,dp[i][j] = dp[i-1][j-1]
     * （二）A[i-1]!=B[j-1]时，又可以分成以下三种情况：
     * 1、从A[0,...i-2]编辑为B[0,...j-1]，再删除A[i-1]
     * 2、从A[0,...i-1]编辑为B[0,...j-2]，再插入B[j-1]
     * 3、从A[0,...i-2]编辑为B[0,...j-2]，再将A[i-1]修改为B[j-1]
     * 每次取三种情况最小值
     * 最后返回dp[n][m];
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();
            int dp[][] = new int[s1.length() + 1][s2.length() + 1];
            dp[0][0] = 0;
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = i;
            }
            for (int i = 1; i < dp[0].length; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1,
                                dp[i - 1][j] + 1));
                    }
                }
            }
            System.out.println(dp[s1.length()][s2.length()]);
        }
    }
}
