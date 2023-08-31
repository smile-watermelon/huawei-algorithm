package com.guagua.sort;

import java.util.Arrays;

/**
 * @类名: CountSort
 * @描述: 计数排序
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/31 14:22
 * @修改历史: （列表如下）
 * 时间    修改人   修改原因  修改内容
 * XXX     XXXX      XXXXX    源文件那个方法的那个代码块
 */
public class CountSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};

        int[] count = count(nums);

        System.out.println(Arrays.toString(count));
    }

    /**
     * todo 计数排序，待完善，有问题
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
}
