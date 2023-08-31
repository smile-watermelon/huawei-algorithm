package com.guagua.sort;

import java.util.Arrays;

/**
 * @类名: ShellSort
 * @描述: 希尔排序
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/31 14:15
 * @修改历史: （列表如下）
 * 时间    修改人   修改原因  修改内容
 * XXX     XXXX      XXXXX    源文件那个方法的那个代码块
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};

        int[] shell = shell(nums);

        System.out.println(Arrays.toString(shell));
    }

    /**
     * 希尔排序
     * 希尔排序是对插入排序的一种改进
     * 本质是将数组按照 h 的跨度进行分割，分割后将距离为 h 的数组值进行交换，ToDo 交换是根据跨度 h 往前移动的。
     * 简单说分两步：
     * 1、让数据值大的尽量往后排，减少和前面数据的位置交换次数（减少了内存的操作）
     * 2、缩小 跨度 h 用插入排序进行，h 跨度内的排序
     * <p>
     * 举例：nums = [6,5,4,3,2,1]
     * 1、首先将数组按照 h = 3 * h + 1 计算得到跨度 h = 4；
     * 2、外层循环初始条件为：i = h = 4, n = 6
     * 2.1、内层第一次循环：循环初始条件为：j = i = 4, h = 4, j >= h，比较 nums[j] = 2，nums[j-h] = 6, ToDo 6和2之间的跨度为4
     * 2 < 6，交换位置
     *          todo 此时 nums 如下：
     *          nums[0] = 2, nums[1] = 5, nums[2] = 4, nums[3] = 3, nums[4] = 6, nums[5] = 1
     *      内层循环结束后 j = j - h = 0; // todo 退出内层循环
     *  3、外层第二次循环初始条件为：i++ 后，i = 5
     *      3.1、内层循环条件为：j = i = 5, j >= h 5 >= 4, 比较 nums[j] = 1, nums[j - h] = 5 todo 1 < 5 进行交换，5和1 之间的跨度为4
     *      todo 此时 nums 如下：
     *      nums[0] = 2, nums[1] = 1, nums[2] = 4, nums[3] = 3, nums[4] = 6, nums[5] = 5
     *  4、第一次 while 循环结束，i = h = h/3 = 4/3 = 1，进行第二轮循环
     *      4.1、第一次外循环条件为：j = i = 1
     *          第一次内循环初始条件为：j = i = 1, j >= h, 比较 nums[j] = 1 和 nums[j-h = 0] = 2 , // todo 1 < 2 进行交换，跨度为 1
     *          todo 此时 nums 如下：
     *          nums[0] = 1, nums[1] = 2, nums[2] = 4, nums[3] = 3, nums[4] = 6, nums[5] = 5
     *          j = j-h = 0 不满足循环，内层循环退出
     *      4.2、第二次外循环条件为：i++ 后 i = 2
     *          第一次内循环条件为：j = i = 2, j >= h (h = 1), 比较 nums[j] = 4 和 nums[j-h = 1] = 2 // todo 4 不小于 2，第一次内循环结束
     *          第二次内循环条件为：j = i = 1, j >= h (h = 1), 比较 nums[j] = 2 和 nums[j-h = 0] = 1 // todo 2 不小于 1，第二次内循环结束
     *      4.3、第三次外循环条件为：i++ 后 i = 3
     *          第一次内循环条件为：j = i = 3, j >= h (h = 1), 比较 nums[j] = 3 和 nums[j-h = 2] = 4 // todo 3 小于 4，进行交换，跨度为 1
     *          todo 此时 nums 如下：
     *          nums[0] = 1, nums[1] = 2, nums[2] = 3, nums[3] = 4, nums[4] = 6, nums[5] = 5
     *          ToDo 之后和4.2一样，根据跨度为1，"逆向" 依次比较 j 前面的数，这里大家应该可以看到和插入排序的操作是没什么区别的，
     *          todo 因为不满足交换条件,所以内层循环结束
     *      4、4、第四次外循环条件为：i++ 后 i = 4
     *          第一次内循环条件为：j = i = 4, j >= h (h = 1), 比较 nums[j] = 6 和 nums[j-h = 3] = 4 // todo 6 不小于 4 后续循环也不会满足交换条件
     *          循环退出
     *      4、5、第五次外循环条件为：i++ 后 i = 5
     *          第一次内循环条件为：j = i = 5, j >= h (h = 1), 比较 nums[j] = 5 和 nums[j-h = 3] = 6 // todo 5 小于 6，进行交换，跨度为 1
     *          todo 此时 nums 如下：
     *          nums[0] = 1, nums[1] = 2, nums[2] = 3, nums[3] = 4, nums[4] = 5, nums[5] = 6
     * <p>
     * 排序完成，后续的循环不满足交换条件
     *
     * @param nums
     * @return
     */
    private static int[] shell(int[] nums) {
        int n = nums.length;
        int h = 1;
        // 获得跨度 h
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // 尽量让大的数值往后排
            for (int i = h; i < n; i++) {
                // 对 h 跨度内的数据进行插入排序操作
                for (int j = i; j >= h; j -= h) {
                    if (nums[j] < nums[j - h]) {
                        int temp = nums[j];
                        nums[j] = nums[j - h];
                        nums[j - h] = temp;
                    }
                }
            }
            // 缩小跨度
            h = h / 3;
        }
        return nums;
    }
}
