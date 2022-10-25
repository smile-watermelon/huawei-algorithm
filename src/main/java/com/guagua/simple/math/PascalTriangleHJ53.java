package com.guagua.simple.math;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/26 00:05
 * @describe HJ53 杨辉三角的变形
 *
 *
 */
public class PascalTriangleHJ53 {

    /**
     * 找规律题
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();

            if (num == 1 || num == 2) {
                System.out.println(-1);
            } else {
                if (num % 2 == 1) {
                    System.out.println(2);
                } else if (num % 4 == 2) {
                    System.out.println(4);
                } else {
                    System.out.println(3);
                }
            }
        }
    }
}
