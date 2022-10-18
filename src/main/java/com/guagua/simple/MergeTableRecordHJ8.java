package com.guagua.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.Callable;

/**
 * @author guagua
 * @date 2022/10/19 00:36
 * @describe 合并表记录
 * <p>
 * 描述
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 * <p>
 * <p>
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 * <p>
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 * <p>
 * 输出描述：
 * 输出合并后的键值对（多行）
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 */
public class MergeTableRecordHJ8 {

    public static void main(String[] args) {

        m1();
    }

    public static void m1() {
        Scanner scanner = new Scanner(System.in);
        int tableSize = scanner.nextInt();
        Map<Integer, Integer> table = new TreeMap<>();
        for (int i = 0; i < tableSize; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if (table.containsKey(key)) {
                table.put(key, table.get(key) + value);
            } else {
                table.put(key, value);
            }
        }
        for (Integer key : table.keySet()) {
            System.out.println( key + " " + table.get(key));
        }
    }


    public static void m() {
        Scanner scanner = new Scanner(System.in);
        int rowNum = scanner.nextInt();
        int[][] table = new int[rowNum][2];
        for (int i = 0; i < rowNum; i++) {

            int index = scanner.nextInt();
            int value = scanner.nextInt();
            System.out.println("--" +index + " " );
            boolean flag = false;
            for (int j = 0; j < table.length; j++) {
                if (table[j][0] == index && !flag) { // 索引存在修改值
                    table[j][1] = table[j][1] + value;
                    flag = true;
                }
            }
            // 不存在添加
            if (!flag) {
                table[i][0] = index;
                table[i][1] = value;
            }
        }

        for (int i = 0; i < table.length; i++) {
            if (table[i][1] != 0) {
                System.out.println(table[i][0] + " " + table[i][1]);
            }
        }
    }
}
