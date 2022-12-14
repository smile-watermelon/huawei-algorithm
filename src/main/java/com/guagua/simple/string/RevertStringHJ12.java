package com.guagua.simple.string;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 12:14
 * @describe 字符串反转
 */
public class RevertStringHJ12 {

    public static void main(String[] args) {
//        m1();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            for (int i = str.length() - 1; i >= 0; i--) {
                result.append(str.charAt(i));
            }

            System.out.println(result);
        }
    }

    private static void m1() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int[] dic = new int[str.length()];
            for (int i = str.length() - 1; i >= 0; i--) {
                dic[i] = str.charAt(i);
            }
            for (int i = dic.length - 1; i >= 0; i--) {
                System.out.print((char) dic[i]);
            }
        }
    }
}
