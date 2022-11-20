package com.guagua.dynamic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author guagua
 * @date 2022/11/20 21:04
 * @describe 整数集合的所有子集
 * <p>
 * 回溯法
 */
public class IntSubCollection {

    public static void main(String[] args) {
        int[] arrs = {1, 2};

//        ArrayList<List<Integer>> result = new ArrayList<>();
//        getSubList(arrs, 0, new LinkedList<>(), result);
//        System.out.println(result);

        int solution = solution(new int[]{2, 5, 7}, 27);
        System.out.println(solution);
    }

    /**
     * 比较难理解，尤其是递归的来回调用，以及递归后代码执行的位置不好追踪
     *
     * @param nums
     * @param index
     * @param sub
     * @param result
     */
    private static void getSubList(int[] nums, int index, LinkedList<Integer> sub, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(sub));
        } else if (index < nums.length) {
            // 每走一步，都要尝试所有的可能
            getSubList(nums, index + 1, sub, result);
            // 尝试往集合中压入一个元素
            sub.add(nums[index]);
            // 压入后再尝试所有可能的结果
            getSubList(nums, index + 1, sub, result);

            sub.removeLast();
        }
    }

    /**
     * 最少使用几个硬币和 = 面值问题
     *
     * @return
     */
    public static int solution(int[] nums, int sum) {
        int[] f = new int[sum + 1];
        int n = nums.length;

        f[0] = 0;
        int i, j;
        // f[1],f[2],...,f[27];
        for (i = 1; i <= sum; ++i) {
            // 最后一个硬币的nums[j]
            f[i] = Integer.MAX_VALUE;
            // min(f[i - num[0] + 1) , ... , f[i - nums[n-1] +1)
            for (j = 0; j < n; ++j) {
                if (i >= nums[j] && f[i - nums[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - nums[j]] + 1, f[i]);
                }
            }
        }
        if (f[sum] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[sum];
    }

    /**
     * 机器人走棋盘格问题
     * 从第0格开始走，走到最后一格总共有多少种走法
     *
     * @param m
     * @param n
     * @return
     */
    public static int UniquePaths(int m, int n) {
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) { // 行 从上到下
            for (int j = 0; j < n; j++) { // 列 从左到右
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }

    /**
     * 青蛙跳问题
     *
     * @return
     */
    public static boolean canJump(int[] A) {
        int n = A.length;

        boolean[] f = new boolean[n];
        f[0] = true;

        for (int i = 1; i < n; i++) {
            f[i] = false;
            // 之前的势头i
            // 最后从i 跳到 j
            for (int j = 0; j < i; j++) {
                if (f[i] && i + A[j] == j) {
                    f[j] = true;
                    break;
                }
            }
        }
        return f[n - 1];
    }


}
