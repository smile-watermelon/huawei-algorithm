package com.guagua.simple;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 21:48
 * @describe 翻转字符串
 */
public class ReverseStringHJ106 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            StringBuilder builder = new StringBuilder();
            for (int i = str.length() -1 ; i >= 0; i--) {
                builder.append(str.charAt(i));
            }
            System.out.println(builder);
        }
    }
}
