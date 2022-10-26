package com.guagua.simple.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * @author guagua
 * @date 2022/10/19 19:00
 * @describe 删除字符串中出现次数最少的字符
 * <p>
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * <p>
 * 数据范围：输入的字符串长度满足 1 \le n \le 20 \1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * <p>
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 * <p>
 * 示例1
 * 输入：aabcddd
 * <p>
 * 输出：aaddd
 */
public class DeleteLeastStrHJ23 {

    public static void main(String[] args) {

//        String a = "abca";
//        System.out.println(a.replace('a', 'd'));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            int[] chars = new int[26];
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            for (int aChar : chars) {
                if (aChar == 0) {
                    continue;
                }
                min = Math.min(aChar, min);
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == min) {
                    str = str.replace(String.valueOf((char) (i + 'a')), "");
                }
            }
            System.out.println(str);
        }
    }

}
