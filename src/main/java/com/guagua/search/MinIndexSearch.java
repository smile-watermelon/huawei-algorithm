package com.guagua.search;

/**
 * @类名: MinIndex
 * @描述:
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/9/28 21:38
 *
 * 求数组中目标元素第一次出现的索引下标
 * 问题：int[] arr = {1, 2, 1, 4, 5, 6, 7, 8, 9, 10}，int target = 1，求数组中目标元素第一次出现的索引下标
 *
 */
public class MinIndexSearch {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 4, 5, 7, 8, 9, 10};

        int target = 10;
        int index = minIndex(arr, target);
        System.out.println("index = " + index);
    }

    private static int minIndex(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                /**
                 * 等于0 说明找完了，第一个元素就是最小值，或者是当前元素的前一个元素不等于目标对象
                 * 说明前一个元素肯定比目标对象要小，当前元素的索引就是最小值
                 */
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;
                }
                // 相等可能还存在最小的元素，继续往下找
                right = mid - 1;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }


}
