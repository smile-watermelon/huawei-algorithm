package com.guagua.sort;

import java.util.Arrays;

/**
 * @类名: SelectSort
 * @描述:
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/31 14:19
 * @修改历史: （列表如下）
 * 时间    修改人   修改原因  修改内容
 * XXX     XXXX      XXXXX    源文件那个方法的那个代码块
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};

        int[] select = select(nums);

        System.out.println(Arrays.toString(select));
    }

    /**
     * 选择排序
     * 本至是从数组中挑出一个数，和数组的的每个数做比较，得到最小的那个数，然后进行位置交换
     * 内层循环一次后，nums 最左边的数是排好序的，所以内层循环的 初始是 j = i + 1
     * 举例：nums = [5,4,3,2,1]
     * 内循环：
     * 1、第一次内循环：初始 i=0，m = 0, j = i + 1 = 1, num[m] = 5，nums[j] = 4，nums[m] > nums[j] 得到小于数字5 nums数组中对应下标为 1
     * 2、第二次内循环：初始 i=0，m = 0, j = 2, num[m] = 5,  nums[j] = 3, nums[m] > nums[j] 得到小于数字5 nums数组中对应下标为 2
     * 将 m 的值 设置为值较小的nums 下标
     * ...继续内层循环，直到找到比 m = i = 0 的数字小的数组下标，此时数组如下：
     * nums[0] = 1, nums[1] = 4, nums[2] = 3, nums[3] = 2, nums[4] = 5;
     * <p>
     * 4、交换两个下标位置的数据
     * 5、开启下一轮外层循环，因为数组最左边的数经过第一轮循环已经排好序，所以 for 循环的初始条件为 j = i + 1
     * <p>
     * 时间复杂度为：O（n²）
     */
    private static int[] select(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int m = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[m] > nums[j]) {
                    m = j;
                    count++;
                }
            }
            // 优化：增加 i != m 判断
            if (i != m) {
                int tmp = nums[i];
                nums[i] = nums[m];
                nums[m] = tmp;
            }
        }
        System.out.println("n = " + nums.length + "，循环次数=" + count);
        return nums;
    }
}
