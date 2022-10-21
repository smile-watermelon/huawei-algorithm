package com.guagua.medium.string;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/21 16:27
 * @describe 整数与IP地址间的转换
 * <p>
 * 描述
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * <p>
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * <p>
 * 数据范围：保证输入的是合法的 IP 序列
 * <p>
 * 输入描述：
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 * <p>
 * 输出描述：
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 * <p>
 * 示例1
 * 输入：
 * 10.0.3.193
 * 167969729
 * 复制
 * 输出：
 * 167773121
 * 10.3.3.193
 */
public class IPConvertHJ33 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            if (s.contains(".")) {
                System.out.println(ip2num(s));
            } else {
                System.out.println(num2ip(Long.parseLong(s)));
            }
        }
    }

    public static long ip2num(String ip) {
        String[] iip = ip.split("\\.");
        Long ans = (long) 0;
        for (int i = 0; i < 4; i++) {
            ans = ans * 256 + Long.parseLong(iip[i]);
        }
        return ans;
    }

    public static String num2ip(long num) {
        String[] ans = new String[4];
        for (int i = 3; i >= 0; i--) {
            ans[i] = Long.toString(num % 256);
            num = num / 256;
        }
        return String.join(".", ans);
    }
}
