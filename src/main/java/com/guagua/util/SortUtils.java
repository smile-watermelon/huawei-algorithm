package com.guagua.util;

import java.util.Random;

/**
 * @author guagua
 * @date 2023/1/9 14:57
 * @describe
 */
public class SortUtils {

    public static int[] random(int n) {
        System.out.println("--------随机数-------");
        int[] result = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            result[i] = random.nextInt(n);
            System.out.println(result[i]);
        }
        System.out.println("---------------");
        return result;
    }

    public static int[] getNums(int n, boolean reserve) {
        int[] result = new int[n];
        if (reserve) {
            for (int i = n; i > 0; i--) {
                result[n - i] = i;
            }
        } else {
            for (int i = 0; i < n; i++) {
                result[i] = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = getNums(15, true);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


}
