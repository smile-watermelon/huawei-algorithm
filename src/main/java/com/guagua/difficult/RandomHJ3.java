package com.guagua.difficult;


import java.util.*;

/**
 * @author guagua
 * @date 2022/10/18 17:58
 * @describe 明明的随机数
 * <p>
 * 描述
 * 明明生成了N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 * <p>
 * 数据范围： 1 ≤ n ≤ 1000  ，输入的数字大小满足 1 ≤ val ≤ 500
 * <p>
 * 输入描述：
 * 第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
 * <p>
 * 输出描述：
 * 输出多行，表示输入数据处理后的结果
 */
public class RandomHJ3 {

    /**
     * 冒泡排序
     */
    public static void bubbleSort() {
        int[] arr = {0, 2, 1};
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // todo 需要优化
    public static void main(String[] args) {
//        bubbleSort();
        sort();
    }

    public static void sort() {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num > 500 || num < 1) {
            System.out.println("请重新输入");
        }

        int[] numbs = new int[num];
        // 读取输入
        for (int i = 0; i < num; i++) {
            int i1 = scanner.nextInt();
            if (i1 >= 1 && i1 <= 500) {
                numbs[i] = i1;
            }
        }

        // 使用冒泡排序
        int t;
        for (int i = 0; i < numbs.length - 1; i++) {
            for (int j = 0; j < numbs.length - 1 - i; j++) {
                if (numbs[j] > numbs[j + 1]) {
                    t = numbs[j];
                    numbs[j] = numbs[j + 1];
                    numbs[j + 1] = t;
                }
            }
        }
        // 输出打印
        int t1 = numbs[0];
        System.out.println(t1);
        for (int i = 1; i < numbs.length; i++) {
            if (t1 != numbs[i]) {
                t1 = numbs[i];
                System.out.println(numbs[i]);
            }

        }
    }
}
