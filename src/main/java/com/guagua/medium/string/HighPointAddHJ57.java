package com.guagua.medium.string;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/20 22:46
 * @describe 高精度整数加法
 * <p>
 * 描述
 * 输入两个用字符串 str 表示的整数，求它们所表示的数之和。
 * <p>
 * 数据范围： 1 \le len(str) \le 10000 \1≤len(str)≤10000
 * 输入描述：输入两个字符串。保证字符串只含有'0'~'9'字符
 * <p>
 * 输出描述：输出求和后的结果
 * <p>
 * 示例1
 * 输入：
 * 9876543210
 * 1234567890
 * <p>
 * 输出：
 * 11111111100
 */
public class HighPointAddHJ57 {

    public static void main(String[] args) {
//        System.out.println((int) '1');
//        System.out.println((int) '0');

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String strA = scanner.next();
            String strB = scanner.next();
//            System.out.println(strA);
//            System.out.println(strB);

            int m = strA.length() - 1;
            int n = strB.length() - 1;
            int carry = 0;
            StringBuilder result = new StringBuilder();
            while (n >= 0 || m >= 0) {
                int digitA = m >= 0 ? strA.charAt(m--) - '0' : 0;
                int digitB = n >= 0 ? strB.charAt(n--) - '0' : 0;
                int sum = digitA + digitB + carry;
                carry = sum >= 10 ? 1 : 0;
                sum = sum >= 10 ? sum - 10 : sum;
                result.append(sum);
            }
            if (carry == 1) {
                result.append(1);
            }
            System.out.println(result.reverse());
        }
    }
}
