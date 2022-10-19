package com.guagua.low;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 16:28
 * @describe 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 * <p>
 * 描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 * <p>
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，元素大小满足 0 \le val \le 100000 \0≤val≤100000
 * 输入描述：
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 * <p>
 * 输出描述：
 * 输出排好序的数字
 * <p>
 * 示例1
 * 输入：
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 * 输出：
 * 1 2 3 4 9 25 55 64
 * <p>
 * 示例2
 * 输入：
 * 5
 * 1 2 3 4 5
 * 1
 * 输出：
 * 5 4 3 2 1
 */
public class IntSortHJ101 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] numbs = new int[len];
        for (int i = 0; i < len; i++) {
            int num = scanner.nextInt();
            numbs[i] = num;
        }

        int flag = scanner.nextInt();
//        System.out.println(len);

//        for (int i = 0; i < numbs.length; i++) {
//            System.out.println(numbs[i]);
//        }
//        System.out.println(flag);

        int t;
        for (int i = 0; i < numbs.length - 1; i++) {
            for (int j = 0; j < numbs.length - 1 - i; j++) {
                if (flag == 0) {
                    if (numbs[j] > numbs[j + 1]) {
                        t = numbs[j];
                        numbs[j] = numbs[j + 1];
                        numbs[j + 1] = t;
                    }
                } else {
                    if (numbs[j] < numbs[j + 1]) {
                        t = numbs[j];
                        numbs[j] = numbs[j + 1];
                        numbs[j + 1] = t;
                    }
                }
            }
        }

        for (int i = 0; i < numbs.length; i++) {
            System.out.print(numbs[i] + " ");
        }
    }
}
