package com.guagua.medium.string;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/20 22:10
 * @describe 字符串通配符
 *
 * 描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 * ？：匹配1个字符
 *
 * 注意：匹配时不区分大小写。
 *
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * 输出：
 *
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 * 数据范围：字符串长度：1\le s\le 100\1≤s≤100
 * 进阶：时间复杂度：O(n^2)\O(n
 * 2
 *  ) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 *
 * 输出描述：
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 */
public class StringRegexHJ71 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String reg = scanner.nextLine(); // te?t*.*
            String str = scanner.nextLine(); // txt12.xls
            String regLower = reg.toLowerCase();
            String strLower = str.toLowerCase();

            // 本质还是用正则匹配，这里只是将题目中出现的正则替换为符合题目语义的规则
            // * 号重复多次替换为1次
            String regx = regLower.replaceAll("\\*{2,}","\\*");
//            System.out.println(regx); // te?t*.*
            // 替换 ？号，问号表示的是不区分大小写重复1次
            regx = regx.replaceAll("\\?","[0-9a-z]{1}");
//            System.out.println(regx); // te[0-9a-z]{1}t*.*
            // 替换 * 号为0次或多次正则
            regx = regx.replaceAll("\\*","[0-9a-z]{0,}");
//            System.out.println(regx); //te[0-9a-z]{1}t[0-9a-z]{0,}.[0-9a-z]{0,}
            System.out.println(strLower.matches(regx));
        }
    }
}
