package com.guagua.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @类名: MaoPaoSort
 * @描述: 冒泡排序
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/31 14:11
 * @修改历史: （列表如下）
 * 时间    修改人   修改原因  修改内容
 * XXX     XXXX      XXXXX    源文件那个方法的那个代码块
 */
public class MaoPaoSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};

        int[] maopao = maopao(nums);

        System.out.println(Arrays.toString(maopao));
    }

    /**
     * 冒泡排序
     * 本质是取出第一个元素挨个和后面的元素进行比较，每次只排好"一个"数
     * 内层一次循环结束，nums 最右边的数是排好序的，所以内层循环的条件是 j < nums.length - 1 - i;
     * 举例：nums = [5,4,3,2,1]
     * 内循环
     * 1、第一次循环：第一个数 5 和 4 比较，5 > 4 交换位置，nums[0] = 4, nums[1] = 5;
     * 2、第二次循环：第一个数 5 和 3 比较，5 > 3 交换位置，num[0] = 4, nums[1] = 3, nums[2] = 5;
     * ... 依次类推，直到 nums[j] 和 nums[j + 1] （数组最后一个元素）比较交换位置，此时数组如下：
     * nums[0] = 4, nums[1] = 3, nums[2] = 2, nums[3] = 1; nums[4] = 5;
     * <p>
     * 3、第一个数 5 排好序
     * 4、开启外层下一轮循环，重复步骤1，2，3
     * <p>
     * 时间复杂度为：O（n²）
     *
     * @param nums
     */
    private static int[] maopao(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                    count++;
                }
            }
        }
        System.out.println("n = " + nums.length + "，循环次数=" + count);

        return nums;
    }
}
