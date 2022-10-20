package com.guagua.simple;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/20 00:22
 * @describe 字符统计
 */
public class CharCountHJ102 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();

            int[] charCount = new int[129]; // asiic 码包含127个字符,数字符号
            for (char c : str.toCharArray()) {
                charCount[c]++;
            }

            int max = Integer.MIN_VALUE;
            for (int i : charCount) {
                max = Math.max(i, max);
            }

            StringBuilder sb = new StringBuilder("");
            while (max!=0) {
                for (int i = 0; i < charCount.length; i++) {
                    if (charCount[i] == max)
                        sb.append((char) (i));
                }
                max--;
            }
            System.out.println(sb);
        }
    }
}
