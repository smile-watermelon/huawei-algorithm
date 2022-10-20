package com.guagua.simple.sort;

import com.sun.xml.internal.ws.api.message.MessageWritable;

import java.util.*;

/**
 * @author guagua
 * @date 2022/10/19 12:32
 * @describe 字符串排序
 * <p>
 * 描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 * <p>
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，字符串长度满足 1 \le len \le 100 \1≤len≤100
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * <p>
 * 示例1
 * 输入：
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * <p>
 * 输出：
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class StringSortHJ14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        ArrayList<String> list = new ArrayList<>(row);
        for (int i = 0; i < row; i++) {
            String line = scanner.next();
            list.add(line);
        }
        list.stream().sorted().forEach(System.out::println);
    }
}
