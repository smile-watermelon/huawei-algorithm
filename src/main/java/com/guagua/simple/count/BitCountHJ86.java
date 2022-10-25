package com.guagua.simple.count;

import com.sun.org.apache.xpath.internal.axes.AxesWalker;

import java.util.Map;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/25 16:25
 * @describe HJ86 求最大连续bit数
 * <p>
 * 描述
 * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * <p>
 * 数据范围：数据组数：1\le t\le 5\1≤t≤5 ，1\le n\le 500000\1≤n≤500000
 * 进阶：时间复杂度：O(logn)\O(logn) ，空间复杂度：O(1)\O(1)
 * 输入描述：
 * 输入一个int类型数字
 * <p>
 * 输出描述：
 * 输出转成二进制之后连续1的个数
 * <p>
 * 示例1
 * 输入：
 * 200
 * 复制
 * 输出：
 * 2
 * 复制
 * 说明：
 * 200的二进制表示是11001000，最多有2个连续的1。
 */
public class BitCountHJ86 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();

            int count = 0;
            int max = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
                num >>= 1;
            }
            System.out.println(max);
        }
    }
}
