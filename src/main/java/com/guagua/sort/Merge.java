package com.guagua.sort;

import com.guagua.util.SortUtils;

import java.util.Arrays;

/**
 * @author guagua
 * @date 2023/1/9 14:50
 * @describe
 */
public class Merge {
    //    private static int[] auxiliary;
    private static int[] auxiliary = {4, 5, 6, 1, 2, 3};

    public static void main(String[] args) {
//        int[] random = SortUtils.random(10);
        int[] sort = sort(SortUtils.getNums(6, true));
        System.out.println("\n-----排序结果-----");
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
//        int[] random1 = new int[]{4, 5, 6, 1, 2, 3};
//        int[] result = merge(random1, 0, 2, 5, 0);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
    }

    /**
     * @param nums
     * @return
     */
    public static int[] sort(int[] nums) {


        auxiliary = new int[nums.length];
        // 创建辅助函数
        // 1,2,3,4,5,6,7,8,9,10
        int[] sort = doSort(nums, 0, nums.length - 1, 0, 0);
        return sort;
    }

    /**
     * 第一次进入方法没有递归
     * 1、刚开始进来 nums = {6, 5, 4, 3, 2, 1}，lower = 0，high = 5
     * 2、if 条件 high <= lower 不成立
     * 3、计算 nums 的中值 mid， mid = lower + （high - lower）/ 2 = 2
     * 4、进入"第一次递归"，停在第一个 sort
     * 第一次递归：
     * 1、sort(int[] nums, lower = 0, high = 2)
     * 2、if 条件 high <= lower 不成立
     * 3、计算 nums 的中值 mid， mid = lower + （high - lower）/ 2 = 1
     * 4、进入递归，
     * 第二次递归：
     * 1、sort(int[] nums, lower = 0, high = 1)
     * 2、if 条件 high <= lower 不成立
     * 3、计算 nums 的中值 mid， mid = lower + （high - lower）/ 2 = 0
     * 4、进入第三次递归，此时方法停在第一个 sort
     * 第三次递归：
     * 1、sort(int[] nums, lower = 0, high = 0)
     * 2、if 条件 high <= lower 成立，退出方法
     * 3、返回值为：nums = {6, 5, 4, 3, 2, 1}
     * 回到第二次递归：
     * 1、mid = 0，high = 1
     * 2、第二个递归：sort(nums, mid + 1, high);
     * 3、执行第二个递归 sort(int[] nums, lower = 1, high = 1)
     * 4、if 条件 high <= lower 成立，退出方法
     * 5、返回值为：nums = {6, 5, 4, 3, 2, 1}
     * 6、进入 merge 方法：merge(nums, lower = 0, mid = 0, high = 1)
     * 6.1、初始值：left = lower = 0，right = mid + 1 = 1，high = 1
     * 6.2、将 nums 的值复制到辅助数组 auxiliary，auxiliary = 【6，5，0，0，0，0】
     * 6.3、for 循环
     * 6.3.1、第一次 for循环：循环条件 i = lower = 0，i <= high = 1
     * if (left > mid) { // left = 0，mid = 0，false
     * nums[i] = auxiliary[right++];
     * } else if (right > high) { // right = 1，high = 1，false
     * nums[i] = auxiliary[left++];
     * } else if (auxiliary[right] < auxiliary[left]) { ToDo auxiliary[right] = 5，auxiliary[left] = 6 true
     * nums[i] = auxiliary[right++]; todo nums = {5, 5, 4, 3, 2, 1}
     * } else if (auxiliary[right] >= auxiliary[left]) { // auxiliary[right] = 5，auxiliary[left] = 6 false
     * nums[i] = auxiliary[left++];
     * }
     * 6.3.2、第二次 for 循环：循环条件 i++，i = 1，i <= high = 1，right = 2
     * if (left > mid) {  // left = 0，mid = 0，false
     * nums[i] = auxiliary[right++];
     * } else if (right > high) { ToDo right = 2，high = 1，true
     * nums[i] = auxiliary[left++]; todo nums = {5, 6, 4, 3, 2, 1}
     * } else if (auxiliary[right] < auxiliary[left]) { ToDo auxiliary[right = 2] = 0，auxiliary[left = 0] = 6 true
     * nums[i] = auxiliary[right++];
     * } else if (auxiliary[right] >= auxiliary[left]) {  // auxiliary[right = 2] = 0，auxiliary[left = 0] = 6 false
     * nums[i] = auxiliary[left++];
     * }
     * 6.3.3、循环结束，退出 merge 方法
     * 回到第一次递归：
     * 1、第二个 sort 递归 因为 if 条件成立，返回 nums = {5, 6, 4, 3, 2, 1}
     * 2、进入 merge
     * 2.1、初始值：nums = {5, 6, 4, 3, 2, 1}
     * mid = 1，high = 2
     * left = lower = 0，right = mid + 1 = 2
     * 2.2、将 nums 的值复制到辅助数组 auxiliary，auxiliary = 【5，6，4，0，0，0】
     * 2.3、for 循环
     * 2.3.1、第一次 for循环：循环条件 i = lower = 0，i <= high = 1
     * if (left > mid) { // left = 0，mid = 1，false
     * nums[i] = auxiliary[right++];
     * } else if (right > high) { // right = 2，high = 2，false
     * nums[i] = auxiliary[left++];
     * } else if (auxiliary[right] < auxiliary[left]) { ToDo auxiliary[right] = 4，auxiliary[left] = 5 true
     * nums[i] = auxiliary[right++]; todo nums = {4, 5, 4, 3, 2, 1}
     * } else if (auxiliary[right] >= auxiliary[left]) { // auxiliary[right] = 4，auxiliary[left] = 5 false
     * nums[i] = auxiliary[left++];
     * }
     * 2.3.2、第二次 for 循环：循环条件 i++，i = 1，i <= high = 2，left = 0，right = 3
     * if (left > mid) {  // left = 0，mid = 1，false
     * nums[i] = auxiliary[right++];
     * } else if (right > high) { ToDo right = 3，high = 2，true
     * nums[i] = auxiliary[left++]; todo nums = {4, 5, 4, 3, 2, 1}
     * } else if (auxiliary[right] < auxiliary[left]) { ToDo auxiliary[right = 3] = 0，auxiliary[left = 0] = 5 true
     * nums[i] = auxiliary[right++];
     * } else if (auxiliary[right] >= auxiliary[left]) {  // auxiliary[right = 3] = 0，auxiliary[left = 0] = 5 false
     * nums[i] = auxiliary[left++];
     * }
     * 2.3.3、第三次 for 循环：循环条件 i++，left++，i = 2，i <= high = 2，left = 1，right = 3
     * if (left > mid) {  // left = 1，mid = 1，false
     * nums[i] = auxiliary[right++];
     * } else if (right > high) { ToDo right = 3，high = 2，true
     * nums[i] = auxiliary[left++]; todo auxiliary[left = 1] = 6; nums = {4, 5, 6, 3, 2, 1}
     * } else if (auxiliary[right] < auxiliary[left]) { ToDo auxiliary[right = 3] = 0，auxiliary[left = 1] = 6 true
     * nums[i] = auxiliary[right++];
     * } else if (auxiliary[right] >= auxiliary[left]) {  // auxiliary[right = 3] = 0，auxiliary[left = 0] = 5 false
     * nums[i] = auxiliary[left++];
     * }
     * 2.3.3、循环结束，退出 merge 方法
     * 回到第一次进入方法没有递归，走第二个 sort：
     * 1、nums = {4, 5, 6, 3, 2, 1}
     * 2、lower = 0, mid = 2, high = 5
     * 2、进入 merge 方法：
     * 2.1、初始值：lower = 3， mid = 3， high = 4
     * left = lower = 3，right = mid + 1 = 4
     * 2.2、将 nums 的值复制到辅助数组 auxiliary，auxiliary = 【5，6，4，3，2，0】
     *
     * @param nums
     * @param lower
     * @param high
     * @return
     */
    private static int[] doSort(int[] nums, int lower, int high, int flag, int count) {
        show(nums, lower, high, flag, count);
        count++;

        if (high <= lower) {
            return nums;
        }
        int mid = lower + (high - lower) / 2;
        // doSort方法的作用是，控制merge 方法调用的正确顺序
        // 排序 mid 左边的数据
        doSort(nums, lower, mid, 1, count);
        // 排序 mid 右边的数据
        doSort(nums, mid + 1, high, 2, count);

        int[] numsSorted = merge(nums, lower, mid, high, flag, count);

        return numsSorted;
    }

    /**
     *
     * @param nums
     * @param lower
     * @param mid
     * @param high
     * @param flag 为了输出打印，标记是左排序，右排序
     * @param count 为了打印递归调用栈，格式化输出 \t 计数
     * @return
     */
    private static int[] merge(int[] nums, int lower, int mid, int high, int flag, int count) {
        showMerge(nums, lower, mid, high, flag, count);
        int left = lower;
        //
        int right = mid + 1;
        // 将数组nums 的元素，复制到辅助数组中
        for (int i = lower; i <= high; i++) {
            auxiliary[i] = nums[i];
        }

        for (int i = lower; i <= high; i++) {
            // 左半边用尽，取右半边元素
            if (left > mid) {
                nums[i] = auxiliary[right++];
                // 右半边用尽，取左半边元素
            } else if (right > high) {
                nums[i] = auxiliary[left++];
                // 右半边的当前元素小于左半边的当前元素，取右半边元素
            } else if (auxiliary[right] < auxiliary[left]) {
                nums[i] = auxiliary[right++];
                // 由半边的当前元素大于等于左半边的当前元素，取左半边元素
            } else if (auxiliary[right] >= auxiliary[left]) {
                nums[i] = auxiliary[left++];
            }
        }
        System.out.printf(getFormat(count) + "nums = %s\n", Arrays.toString(nums));
        return nums;
    }

    private static String getFormat(int count) {
        String f = "";
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                f += "\t";
            }
        }
        return f;
    }

    private static void show(int[] nums, int lower, int high, int flag, int count) {
        String f = getFormat(count);
        if (flag == 1) {
            System.out.printf(f + "左排序 doSort(%s, %d, %d)\n", Arrays.toString(nums), lower, high);
        } else if (flag == 2) {
            System.out.printf(f + "右排序 doSort(%s, %d, %d)\n", Arrays.toString(nums), lower, high);
        } else {
            System.out.printf("排序开始 doSort(%s, %d, %d)\n", Arrays.toString(nums), lower, high);
        }
    }

    private static void showMerge(int[] nums, int lower, int mid, int high, int flag, int count) {
        String f = getFormat(count);
        if (flag == 1) {
            System.out.printf(f + "左排序 merge(%s, %d, %d, %d)\n", Arrays.toString(nums), lower, mid, high);
        } else if (flag == 2) {
            System.out.printf(f + "右排序 merge(%s, %d, %d, %d)\n", Arrays.toString(nums), lower, mid, high);
        } else {
            System.out.printf("排序结束 merge(%s, %d, %d, %d)\n", Arrays.toString(nums), lower, mid, high);
        }
    }


}
