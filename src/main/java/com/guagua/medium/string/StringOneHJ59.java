package com.guagua.medium.string;

import javax.sql.rowset.spi.SyncResolver;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/20 20:41
 * @describe 找出字符串中第一个只出现一次的字符
 * <p>
 * 描述: 找出字符串中第一个只出现一次的字符
 * <p>
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 * <p>
 * 输入描述：输入一个非空字符串
 * <p>
 * 输出描述：输出第一个只出现一次的字符，如果不存在输出-1
 * <p>
 * 示例1
 * 输入：asdfasdfo
 * 输出：o
 */
public class StringOneHJ59 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.length() == 1) {
                System.out.println(str);
                continue;
            }
            int flag = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                    System.out.println(str.charAt(i));
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(-1);
            }
        }
    }
}
