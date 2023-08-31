package com.guagua.sort;

import java.util.Arrays;

/**
 * @类名: InsertSort
 * @描述:
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/31 14:18
 * @修改历史: （列表如下）
 * 时间    修改人   修改原因  修改内容
 * XXX     XXXX      XXXXX    源文件那个方法的那个代码块
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};

        int[] insert = insert(nums);

        System.out.println(Arrays.toString(insert));
    }

    /**
     * <p> 插入排序
     * <p> 本质是从数组中选出一个数 i，插入到已经排列好的数组 nums[i-1],nums[i-2] ... 中
     * 数组中 i 左侧是排序好的
     * <p> 举例：nums = [5,4,3,2,1]
     * <p> 循环：
     * <p> 1、第一次循环：初始条件 i = 1，j = i = 1, nums[j] = 4, nums[j-1] = 5, nums[j] < nums[j -1] 即 4 < 5，交换4和5的位置
     * nums[0] = 4, nums[1] = 5, j-- = 0 不满足内层循环条件，内层循环结束;
     *
     *      todo 此时 nums 如下：
     *      nums[0] = 4, nums[1] = 5, nums[2] = 3, nums[3] = 2, nums[4] = 1; ToDo 4 和 5 排序好了
     *
     * <p> 2、第二次 外 循环：初始条件为 i = 2， j = i = 2, nums[j] = 3, nums[j - 1] = 5, nums[j] < nums[j -1] 即 3 < 5，交换3和5的位置
     *
     *      todo 此时 nums 如下：
     *      nums[0] = 4, nums[1] = 3, nums[2] = 5, nums[3] = 2, nums[4] = 1; ToDo 将数字 3 插入 到已经排序好的 4 和 5 中间
     *      内循环进行第二轮操作：j-- 后，j = 1, nums[j] = 3， nums[j - 1] = 4, nums[j] < nums[j -1]， 即 3 < 4， 交换3和4的位置
     *
     *      ToDo 此时 nums 如下：
     *      nums[0] = 3, nums[1] = 4, nums[2] = 5, nums[3] = 2, nums[4] = 1; ToDo 将数字 3 插入到索引 0 的位置
     *  ...继续内外层循环直到 i = n - 1 到达数组的最后一位，所有数字都排好序
     * <p>
     * 插入排序对部分已经排好序的数组进行排序会很快
     */
    private static int[] insert(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
        return nums;
    }
}
