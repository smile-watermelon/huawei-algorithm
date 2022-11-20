package com.guagua.search;

/**
 * @author guagua
 * @date 2022/11/18 13:58
 * @describe 二分查找，也称折半查找，前提是查找的数据是排序好的，总共分三步
 * 1、判断中间是不是等于目标值，相等直接返回
 * 2、如果目标 值大于中间值，说明目标值在中间值的右侧，修改 start = middle + 1
 * 3、如果目标值小于中间值，说明目标值是在中间值的左侧，修改 end = middle - 1
 * <p>
 * 时间复杂度是 O(log(2)(N))
 */
public class MyBinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 11;

        int index = binarySearch(arr, target);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int middle;

        while (start <= end) {
            middle = (end + start) >>> 1;
            if (arr[middle] == target) {
                return middle;
            }
            if (arr[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }
}
