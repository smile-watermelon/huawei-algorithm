package com.guagua.sort;

import java.util.Random;

/**
 * @author guagua
 * @date 2022/10/19 16:57
 * @describe 整数排序
 */
public class IntSort {

    public static void main(String[] args) {
        int[] nums = {1, 4, 21, 10, 11, 6};

        int[] maopao = maopao(nums);
        for (int i = 0; i < maopao.length; i++) {
            System.out.println(maopao[i]);
        }
        System.out.println("---------");
        int[] quick = quick(nums);
        for (int i : quick) {
            System.out.println(i);
        }

        System.out.println("----------");
        int[] count = count(nums);
        for (int i : count) {
            System.out.println(i);
        }
        System.out.println("----------");
        int[] merge = merge(nums);
        for (int i : merge) {
            System.out.println(i);
        }
    }

    /**
     * 归并排序
     *
     * @param nums
     */
    private static int[] merge(int[] nums) {
        int length = nums.length;
        int[] src = nums;
        int[] dst = new int[length];
        for (int seg = 1; seg < length; seg += seg) {
            for (int start = 0; start < length; start += seg * 2) {

                int mid = Math.min(start + seg, length);
                int end = Math.min(start + seg * 2, length);
                int i = start, j = mid, k = start;

                while (i < mid || j < end) {
                    if (j == end || (i < mid && src[i] < src[j])) {
                        dst[k++] = src[i++];
                    } else {
                        dst[k++] = src[j++];
                    }
                }

            }
            int[] temp = src;
            src = dst;
            dst = temp;
        }

        return src;
    }

    /**
     * 计数排序
     *
     * @param nums
     */
    private static int[] count(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]--;
        }
        int i = 0;
        for (int num = min; num <= max; num++) {
            while (counts[num - min] > 0) {
                nums[i++] = num;
                counts[num - min]--;
            }
        }
        return nums;
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


    /**
     * 冒泡排序
     *
     * @param nums
     */
    private static int[] maopao(int[] nums) {
        int t;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }
        return nums;
    }


}
