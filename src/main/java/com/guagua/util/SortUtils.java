package com.guagua.util;

import java.security.InvalidParameterException;
import java.util.Random;

/**
 * @author guagua
 * @date 2023/1/9 14:57
 * @describe
 */
public class SortUtils {

    public static int[] random(int n) {
        if (n < 0) {
            throw new InvalidParameterException("n 必须大于0");
        }
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
        if (n < 0) {
            throw new InvalidParameterException("n 必须大于0");
        }
        int[] result = new int[n];
        if (reserve) {
            for (int i = n; i > 0; i--) {
                result[n - i] = i;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                result[i - 1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = getNums(15, true);
        int[] nums = getNums(15, false);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


}
