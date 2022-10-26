package com.guagua.low;

import java.util.*;

/**
 * @author guagua
 * @date 2022/10/19 11:23
 * @describe 提取不重复的整数
 *
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 * 数据范围： 1 <= n <= 10^{8}
 * 输入描述：输入一个int型整数
 *
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入：9876673
 *
 * 输出：37689
 */
public class ExtractIntHJ9 {

    public static void main(String[] args) {
        // 方式1
//        linkedHashSetExtract();
        // 方式2
        reminder();
    }

    private static void reminder() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            HashSet<Object> set = new HashSet<>();
            if (i < 1 || i > Math.pow(10, 8)) {
                System.out.println("请输入正确的参数");
                continue;
            }
            while (i != 0) {
                int temp =  i % 10;
                if (set.add(temp)) {
                    System.out.print(temp);
                }
                i /=10;
            }
        }
    }

    private static void linkedHashSetExtract() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();

            if (i < 1 || i > Math.pow(10, 8)) {
                System.out.println("请输入正确的参数");
                continue;
            }
            char[] chars = String.valueOf(i).toCharArray();
            System.out.println(chars);
            LinkedHashSet<String> map = new LinkedHashSet<>();
            for (int i1 = chars.length - 1; i1 >= 0; i1--) {
                map.add(String.valueOf(chars[i1]));
            }
            System.out.println(map);

        }
    }
}
