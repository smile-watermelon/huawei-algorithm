package com.guagua.simple.array;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author guagua
 * @date 2022/10/25 18:34
 * @describe HJ80 整型数组合并
 * <p>
 * 描述
 * 题目标题：
 * <p>
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格。
 * <p>
 * <p>
 * <p>
 * 输入描述：
 * 输入说明，按下列顺序输入：
 * 1 输入第一个数组的个数
 * 2 输入第一个数组的数值
 * 3 输入第二个数组的个数
 * 4 输入第二个数组的数值
 * <p>
 * 输出描述：
 * 输出合并之后的数组
 * <p>
 * 示例1
 * 输入：
 * 3
 * 1 2 5
 * 4
 * -1 0 3 2
 * 复制
 * 输出：
 * -101235
 */
public class MergeArrayHJ80 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                treeSet.add(scanner.nextInt());
            }
            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                treeSet.add(scanner.nextInt());
            }
            treeSet.forEach(System.out::print);
        }
    }
}
