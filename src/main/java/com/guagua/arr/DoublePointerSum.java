package com.guagua.arr;

/**
 * @类名: DoublePointerDemo
 * @描述: 双指针求两数之和
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/30 17:25
 * @修改历史: （列表如下）
 * 时间    修改人   修改原因  修改内容
 * XXX     XXXX      XXXXX    源文件那个方法的那个代码块
 */
public class DoublePointerSum {

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 1, 2, 3, 5, 8};
        sumTwoNumber(arr, n);

    }

    /**
     * 问题：在数组 arr =【1，1，2，3，5，8】中，满足 arr[i] + arr[i + 1] = arr[n]
     * 求第 i = n 时， arr[n]的两数之和的值。
     * 题解：
     * 1、根据题意，后一个数是前两个数之和，所以很明显可以想到采用双指针移动的方式，
     * 2、第一个指针指向 arr[i]，第二个指针使用 arr[j] 表示 arr[i + 1]，
     * 3、循环条件是，j 一定不能大于 arr.length - 1，如果 j 大于 arr.length - 1 会出现数组越界的问题，因为j 的后一个值才是两数之和的值
     * 4、然后判断 j + 1 等不等 n，如果等于n 说明指针已经移动到了目标值
     * 5、返回 i 的值
     *
     * @param n
     */
    private static void sumTwoNumber(int[] arr, int n) {
        if (n > arr.length - 1) {
            throw new RuntimeException("参数错误");
        }

        for (int i = 0, j = 1; j < arr.length - 1; i++, j++) {
            int index = j + 1;
            if (index == n) {
                arr[n] = arr[i] + arr[j];
                System.out.printf("%d + %d = %d\n", arr[i], arr[j], arr[n]);
                System.out.printf("arr[i]的索引 = %d， arr[j]的索引 = %d", i, j);
                break;
            }
        }
    }




}
