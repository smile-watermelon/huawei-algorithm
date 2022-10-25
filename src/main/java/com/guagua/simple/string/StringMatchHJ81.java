package com.guagua.simple.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/25 14:24
 * @describe HJ81 字符串字符匹配
 *
 * 描述
 * 判断短字符串S中的所有字符是否在长字符串T中全部出现。
 * 请注意本题有多组样例输入。
 * 数据范围:1\le len(S),len(T)\le200\1≤len(S),len(T)≤200
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 *
 * 输出描述：
 * 如果短字符串的所有字符均在长字符串中出现过，则输出字符串"true"。否则输出字符串"false"。
 *
 * 示例1
 * 输入：
 * bc
 * abc
 * 复制
 * 输出：
 * true
 * 复制
 * 说明：
 * 其中abc含有bc，输出"true"
 */
public class StringMatchHJ81 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {
                map.put(a.charAt(i), 0);
            }
            for (int i = 0; i < b.length(); i++) {
                if (map.containsKey(b.charAt(i))) {
                    map.put(b.charAt(i), 1);
                }
            }
            boolean res = true;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() ==0) {
                    res = false;
                }
            }
            System.out.println(res);
        }
    }
}
