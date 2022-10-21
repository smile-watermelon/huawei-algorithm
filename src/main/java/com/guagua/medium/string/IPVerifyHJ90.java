package com.guagua.medium.string;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/21 19:54
 * @describe HJ90 合法IP
 * <p>
 * 描述
 * IPV4地址可以用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此正号不需要出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 * <p>
 * 现在需要你用程序来判断IP是否合法。
 * <p>
 * 数据范围：数据组数：1\le t\le 18\1≤t≤18
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * <p>
 * 输入描述：
 * 输入一个ip地址，保证不包含空格
 * <p>
 * 输出描述：
 * 返回判断的结果YES or NO
 * <p>
 * 示例1
 * 输入：
 * 255.255.255.1000
 * <p>
 * 输出：
 * NO
 */
public class IPVerifyHJ90 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String ip = scanner.nextLine();
            String[] ipArr = ip.split("\\.");
            if (ipArr.length != 4) {
                System.out.println("NO");
                continue;
            }
            boolean isIP = true;
            for (int i = 0; i < ipArr.length; i++) {
                int tmp;
                try {
                    tmp = Integer.parseInt(ipArr[i]);
                } catch (Exception e) {
                    isIP = false;
                    break;
                }
                if (tmp < 0 || tmp > 255) {
                    isIP = false;
                    break;
                }
                if (ipArr[i].length() != String.valueOf(tmp).length()) {
                    isIP = false;
                    break;
                }
            }
            System.out.println(!isIP ? "NO" : "YES");
        }
    }
}
