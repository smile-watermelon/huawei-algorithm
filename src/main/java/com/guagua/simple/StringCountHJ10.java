package com.guagua.simple;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 11:51
 * @describe 字符个数统计
 * <p>
 * 描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 * <p>
 * 数据范围： 1 <= n <= 500 \1≤n≤500
 * 输入描述：
 * 输入一行没有空格的字符串。
 * <p>
 * 输出描述：
 * 输出 输入字符串 中范围在(0~127，包括0和127)字符的种数。
 */
public class StringCountHJ10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] map = new int[127];
            String str = scanner.nextLine();
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                map[str.charAt(i)] = 1;
            }
            for (int i = 0; i < map.length; i++) {
                if (map[i] == 1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
