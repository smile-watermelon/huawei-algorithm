package com.guagua.low;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 15:55
 * @describe 截取字符串
 */
public class SubStringHJ46 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            int len = scanner.nextInt();
            int strLength = str.length();
            if (strLength < 1 || strLength > 1000 || len < 1 || len > 1000) {
                System.out.println("字符串长度大于1 小于1000");
                continue;
            }
            System.out.println(str.substring(0, len));
        }
    }
}
