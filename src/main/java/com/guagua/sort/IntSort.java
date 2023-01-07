package com.guagua.sort;

import java.util.Random;

/**
 * @author guagua
 * @date 2022/10/19 16:57
 * @describe 整数排序
 */
public class IntSort {

    public static int[] random(int n) {
        int[] result = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            result[i] = random.nextInt(10);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 4, 21, 10, 11, 6};
        int[] nums = {5, 4, 3, 2, 1};


//        int[] maopao = maopao(nums);
//        for (int i = 0; i < maopao.length; i++) {
//            System.out.println(maopao[i]);
//        }

//        int[] random = random(10);
        System.out.println("--------------");
//        int[] select = select(random);

        int[] select = select(nums);
        for (int i = 0; i < select.length; i++) {
            System.out.println(select[i]);
        }

//        System.out.println("---------");
//        int[] quick = quick(nums);
//        for (int i : quick) {
//            System.out.println(i);
//        }
//
//        System.out.println("----------");
//        int[] count = count(nums);
//        for (int i : count) {
//            System.out.println(i);
//        }
//        System.out.println("----------");
//        int[] merge = merge(nums);
//        for (int i : merge) {
//            System.out.println(i);
//        }
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
     * 本质是取出第一个元素挨个和后面的元素进行比较，每次只排好"一个"数
     * 内层一次循环结束，nums 最右边的数是排好序的，所以内层循环的条件是 j < nums.length - 1 - i;
     * 举例：nums = [5,4,3,2,1]
     * 内循环
     * 1、第一次循环：第一个数 5 和 4 比较，5 > 4 交换位置，nums[0] = 4, nums[1] = 5;
     * 2、第二次循环：第一个数 5 和 3 比较，5 > 3 交换位置，num[0] = 4, nums[1] = 3, nums[2] = 5;
     *      ... 依次类推，直到 nums[j] 和 nums[j + 1] （数组最后一个元素）比较交换位置，此时数组如下：
     *      nums[0] = 4, nums[1] = 3, nums[2] = 2, nums[3] = 1; nums[4] = 5;
     *
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

    /**
     * 选择排序
     * 本至是从数组中挑出一个数，和数组的的每个数做比较，得到最小的那个数，然后进行位置交换
     * 内层循环一次后，nums 最左边的数是排好序的，所以内层循环的 初始是 j = i + 1
     * 举例：nums = [5,4,3,2,1]
     * 内循环：
     * 1、第一次内循环：初始 i=0，m = 0, j = i + 1 = 1, num[m] = 5，nums[j] = 4，nums[m] > nums[j] 得到小于数字5 nums数组中对应下标为 1
     * 2、第二次内循环：初始 i=0，m = 0, j = 2, num[m] = 5,  nums[j] = 3, nums[m] > nums[j] 得到小于数字5 nums数组中对应下标为 2
     *      将 m 的值 设置为值较小的nums 下标
     *      ...继续内层循环，直到找到比 m = i = 0 的数字小的数组下标，此时数组如下：
     *      nums[0] = 1, nums[1] = 4, nums[2] = 3, nums[3] = 2, nums[4] = 5;
     *
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
            int tmp = nums[i];
            nums[i] = nums[m];
            nums[m] = tmp;

        }
        System.out.println("n = " + nums.length + "，循环次数=" + count);
        return nums;
    }

    /**
     * 插入排序
     * 本质是从
     */
    private static int[] insert(int[] nums) {

        return nums;
    }

}
