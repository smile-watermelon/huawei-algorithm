package com.guagua.medium.logic;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/21 17:51
 * @describe 求小球落地5次后所经历的路程和第5次反弹的高度
 * <p>
 * 描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 * <p>
 * <p>
 * 数据范围：输入的小球初始高度满足 1 \le n \le 1000 \1≤n≤1000  ，且保证是一个整数
 * <p>
 * 输入描述：
 * 输入起始高度，int型
 * <p>
 * 输出描述：
 * 分别输出第5次落地时，共经过多少米以及第5次反弹多高。
 * 注意：你可以认为你输出保留六位或以上小数的结果可以通过此题。
 * 示例1
 * 输入：
 * 1
 * 复制
 * 输出：
 * 2.875
 * 0.03125
 */
public class BounceHeightHJ38 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            // 初始高度
            int a = in.nextInt();
            double d = a;
            //记录下落的路程
            double sum1 = 0;
            //记录弹起的路程
            double sum2 = 0;
            for (int i = 0; i < 5; i++) {
                sum1 += d;
                d = d / 2;
                sum2 += d;
            }
            //第五次之后未弹起，须减掉
            System.out.println(sum1 + sum2 - d);
            System.out.println(d);
        }
    }
}
