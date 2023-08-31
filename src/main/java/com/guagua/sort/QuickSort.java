package com.guagua.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @类名: QuickSort
 * @描述:
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/31 14:21
 * @修改历史: （列表如下）
 * 时间    修改人   修改原因  修改内容
 * XXX     XXXX      XXXXX    源文件那个方法的那个代码块
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int[] quick = quick(nums);

        System.out.println(Arrays.toString(quick));
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    private static int[] quick(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (end > start) {
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    private static int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);
        int small = start - 1;
        for (int i = start; i < end; ++i) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, i, small);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private static void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

}
