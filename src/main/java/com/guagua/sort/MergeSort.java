package com.guagua.sort;

import java.util.Arrays;

/**
 * @类名: MergeSort
 * @描述: 归并排序
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/31 14:17
 * @修改历史: （列表如下）
 * 时间    修改人   修改原因  修改内容
 * XXX     XXXX      XXXXX    源文件那个方法的那个代码块
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};

        int[] merge = merge(nums);

        System.out.println(Arrays.toString(merge));
    }

    /**
     * todo 归并排序，待完善理解注释
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

}
