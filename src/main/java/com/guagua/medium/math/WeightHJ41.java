package com.guagua.medium.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author guagua
 * @date 2022/10/22 17:37
 * @describe HJ41 称砝码
 * <p>
 * 描述
 * 现有n种砝码，重量互不相等，分别为 m1,m2,m3…mn ；
 * 每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 * <p>
 * <p>
 * 注：
 * <p>
 * 称重重量包括 0
 * <p>
 * 数据范围：每组输入数据满足 1 \le n \le 10 \1≤n≤10  ， 1 \le m_i \le 2000 \1≤m
 * i
 * ​
 * ≤2000  ， 1 \le x_i \le 10 \1≤x
 * i
 * ​
 * ≤10
 * 输入描述：
 * 对于每组测试数据：
 * 第一行：n --- 砝码的种数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
 * 输出描述：
 * 利用给定的砝码可以称出的不同的重量数
 * <p>
 * 示例1
 * 输入：
 * 2
 * 1 2
 * 2 1
 * 复制
 * 输出：
 * 5
 * 复制
 * 说明：
 * 可以表示出0，1，2，3，4五种重量。
 */
public class WeightHJ41 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextLine()) { // 注意 while 处理多个 case
                String nString = in.nextLine();
                int n = Integer.parseInt(nString);
                String[] weightsSting = in.nextLine().split(" ");
                String[] numsSting = in.nextLine().split(" ");

                // 各砝码重量
                int[] weights = new int[n];
                for (int i = 0; i < weightsSting.length; i++) {
                    weights[i] = Integer.parseInt(weightsSting[i]);
                }
                // 砝码数量
                int[] nums = new int[n];
                for (int i = 0; i < numsSting.length; i++) {
                    nums[i] = Integer.parseInt(numsSting[i]);
                }
                // 所有砝码重量组合情况set
                HashSet<Integer> hashSet = new HashSet<>();
                //由示例可知，0重量也属于一种情况
                hashSet.add(0);
                for (int i = 0; i < n; i++) { //每一种砝码
                    // 记录每一种砝码的重量总分类
                    HashSet<Integer> thisTimeNeedAddSet = new HashSet<>();
                    // 砝码数量
                    for (int k = 1; k <= nums[i]; k++) {
                        // 砝码数量组合
                        int singleTimeAddWeight = weights[i] * k;
                        // 添加当前重量
                        thisTimeNeedAddSet.add(singleTimeAddWeight);
                        for (Integer weight : hashSet) {
                            // 之前之前砝码 和当前砝码的组合
                            thisTimeNeedAddSet.add(weight + singleTimeAddWeight);
                        }
                    }
                    // 添加当前砝码种类
                    hashSet.addAll(thisTimeNeedAddSet);
                }
                System.out.println(hashSet.size());
            }
        }
    }
}





















