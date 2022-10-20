package com.guagua.medium.string;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/21 01:48
 * @describe HJ32 密码截取
 * <p>
 * 描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 * <p>
 * 数据范围：字符串长度满足 1 \le n \le 2500 \1≤n≤2500
 * 输入描述：
 * 输入一个字符串（字符串的长度不超过2500）
 * <p>
 * 输出描述：
 * 返回有效密码串的最大长度
 * <p>
 * 示例1
 * 输入：
 * ABBA
 * 复制
 * 输出：
 * 4
 * 复制
 * 示例2
 * 输入：
 * ABBBA
 * 复制
 * 输出：
 * 5
 * 复制
 * 示例3
 * 输入：
 * 12HHHHA
 * 复制
 * 输出：
 * 4
 */
public class PasswordSubHJ32 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(count(str));
        }
    }

    public static int count(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            int l1 = getLen(str, i, i);
            int l2 = getLen(str, i, i + 1);
            res = Math.max(res, Math.max(l1, l2));
        }
        return res;
    }

    public static int getLen(String str, int l, int r) {
//        int len = 0;
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--; // 这满足 l = 0 的情况下，l-- = -1
            r++;
        }
        return r - l - 1;
    }


}
